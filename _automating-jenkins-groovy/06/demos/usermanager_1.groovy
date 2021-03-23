import hudson.model.User;

class UserManager{
  Set allUsers(){
    return User.getAll();
  }
}

def mgr = new UserManager();

for (user in mgr.allUsers()){
	println(user.id); 
}


