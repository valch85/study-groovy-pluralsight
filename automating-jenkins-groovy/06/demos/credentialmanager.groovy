import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.common.*;
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl;

class CredentialManager{
  Set getAll(){
	return CredentialsProvider.lookupCredentials(StandardUsernameCredentials.class, Jenkins.instance, null, null);
  }  
  
  void changePassword(String credentialId, String password){
    println 'change password';
        /*
    def creds = CredentialsProvider.lookupCredentials(StandardUsernameCredentials.class, Jenkins.instance, null, null);
    
    def credential = creds.findResult { it.id == credentialId ? it : null };
      
    if (credential != null){
      def credentials_store = jenkins.model.Jenkins.instance.getExtensionList(
            'com.cloudbees.plugins.credentials.SystemCredentialsProvider'
            )[0].getStore()

        def success = credentials_store.updateCredentials(
            com.cloudbees.plugins.credentials.domains.Domain.global(), 
            credential, 
            new UsernamePasswordCredentialsImpl(credential.scope, credential.id, credential.description, credential.username, password)
            )

        if (!success) {
            throw new RuntimeException("Changing password failed.");
        }
      
      	println("password change complete");
    }
      */

  }
}

def mgr = new CredentialManager()

mgr.changePassword("githubcreds", "password");


