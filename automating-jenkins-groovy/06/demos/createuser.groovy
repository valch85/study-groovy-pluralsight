import jenkins.model.*
import hudson.security.*


void createUser(userName, password){
	def instance = Jenkins.getInstance()

	def hudsonRealm = new HudsonPrivateSecurityRealm(false)
	hudsonRealm.createAccount(userName, password)
	instance.setSecurityRealm(hudsonRealm)
	instance.save()
}