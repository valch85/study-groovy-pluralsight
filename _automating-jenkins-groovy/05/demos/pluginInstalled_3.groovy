class PluginCheck{
  
  String key;
  BigDecimal pluginVersion;
  def internalPlugin;
  
  PluginCheck(String artifactId, String version){
  		key = artifactId; 
    	pluginVersion = new BigDecimal(version);
    	internalPlugin = new ArrayList<String>(Jenkins.instance.pluginManager.plugins).find { x -> x.shortName == this.key };
  }
  
  String shortName(){
  	return internalPlugin.shortName; 
  }
  
  String displayName(){
   return internalPlugin.displayName; 
  }
  
  String installedVersion(){
  	return internalPlugin.version;
  }

  Boolean isInstalled(){       
      return internalPlugin != null && new BigDecimal(internalPlugin.version) > this.pluginVersion;      
  }
  
  void install(){
   	Jenkins.instance.updateCenter.getPlugin(key).deploy();
  }
}

def pluginCheck = new PluginCheck("jobConfigHistory", "2.0");

if (!pluginCheck.isInstalled()){
	pluginCheck.install(); 
}
else{
  println(pluginCheck.isInstalled() ? "Installed" : "Not Installed");
  println(pluginCheck.shortName());
  println(pluginCheck.installedVersion());
}