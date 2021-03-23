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
  
  Set whitelistedNotInstalled(){
  	return pluginIds.minus(installedPluginIds()); 
  }
  
  void disableNotWhitelisted(){
    for(pluginId in installedNotInWhitelist()){
    	PluginCheck plugin = new PluginCheck(pluginId, ".9");
      
      if (plugin.enabled){
        println('enabled, disabling');
       	plugin.disable(); 
      }
    }
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
  
  Boolean getEnabled(){
   	return internalPlugin.isEnabled(); 
  }
  
  void disable(){
    	internalPlugin.disable();
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
  
  void installWhitelist(){
   //for (pluginId in  
  }
}

def pluginManager = new PluginManager();

/*pluginManager.disableNotWhitelisted();
pluginManager.installWhitelist();

for(plugin in pluginManager.installedNotInWhitelist()){
 println(plugin); 
}*/
        
        for(plugin in pluginManager.whitelistedNotInstalled()){
         println(plugin); 
        }