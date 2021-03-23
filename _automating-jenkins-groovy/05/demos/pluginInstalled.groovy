Boolean isInstalled(String displayName){
	def plugin = new ArrayList<String>(Jenkins.instance.pluginManager.plugins).find { x -> x.displayName == displayName };

	return plugin != null;      
}
  
println(isInstalled("Job Configuration History Plugin") ? "Installed" : "Not Installed");