class PluginCheck{
  
  String key;
  BigDecimal pluginVersion;
  def internalPlugin;
  
  PluginCheck(String displayName, String version){
  		key = displayName; 
    	pluginVersion = new BigDecimal(version);
    	internalPlugin = new ArrayList<String>(Jenkins.instance.pluginManager.plugins).find { x -> x.displayName == this.key };
  }
  
  String shortName(){
  	return internalPlugin.shortName; 
  }
  
  String installedVersion(){
  	return internalPlugin.version;
  }

  Boolean isInstalled(){       
      return internalPlugin != null && new BigDecimal(internalPlugin.version) > this.pluginVersion;      
  }
  
  void install(){
  	Jenkins.instance.updateCenter.getPlugin(key).deploy()
  }
}

def pluginCheck = new PluginCheck("Job Configuration History Plugin", "2.0");
  
println(pluginCheck.isInstalled() ? "Installed" : "Not Installed");
println(pluginCheck.shortName());
println(pluginCheck.installedVersion());