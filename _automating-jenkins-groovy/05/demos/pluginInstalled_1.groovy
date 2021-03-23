Boolean isInstalled(String displayName, BigDecimal version){
	def plugin = new ArrayList<String>(Jenkins.instance.pluginManager.plugins).find { x -> x.displayName == displayName };
      
	return plugin != null && new BigDecimal(plugin.version) > version;      
}
  
println(isInstalled("Job Configuration History Plugin", 2.0) ? "Installed" : "Not Installed");