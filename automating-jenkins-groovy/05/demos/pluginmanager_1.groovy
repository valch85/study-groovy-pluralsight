class PluginManager{
  Set pluginIds;
  
  PluginManager(){
  	File whiteList = new File("/var/jenkins_home/userContent/whitelist.txt");
    pluginIds = whiteList.readLines();
  }
  
  Set installedPluginIds(){
    return (Set)(Jenkins.instance.pluginManager.plugins.shortName);
  }
  
  Set installedNotInWhitelist(){
    return installedPluginIds().minus(pluginIds).sort(); 
  }
}

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
def pluginManager = new PluginManager();

/*for (plugin in pluginManager.pluginIds){
 println(plugin); 
}

for (plugin in pluginManager.installedPluginIds()){
 println('\t' + plugin);  
}*/

for (plugin in pluginManager.installedNotInWhitelist()){
 	println(plugin); 
}