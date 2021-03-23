import hudson.model.User;
import hudson.security.*

class UserManager{
  Set allUsers(){
    return User.getAll();
  }
  
  void createUser(String userName, String password){
    if (!this.userExists(userName)){
      Jenkins instance = Jenkins.getInstance();
      
      def realm = new HudsonPrivateSecurityRealm(false);
        
      realm.createAccount(userName, password);
      instance.setSecurityRealm(realm);
      instance.save();
    }
  }
  
  Boolean userExists(userName){
	return User.get(userName) != null;
  }
  
  void deleteUser(String userId){
  	if (this.userExists(userId)){
	    User u = User.get(userId);
	    u.delete();
	}
  }
}

def mgr = new UserManager();
mgr.createUser("test", "user");

mgr.deleteUser("test");

println(mgr.userExists("cbehrens"));

for (user in mgr.allUsers()){
	println(user.id); 
}

