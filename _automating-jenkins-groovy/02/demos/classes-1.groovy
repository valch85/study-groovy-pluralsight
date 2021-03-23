class User{
    String lastName;
    String firstName;
    
    public String UserName(){
        return getUserName(this.firstName, this.lastName);
    }

    private String getUserName(String firstName, String lastName){
        return firstName.substring(0,1).toLowerCase() + lastName.toLowerCase();
    }
}

String[] firstNames = ["Bob", "Jeff", "Roy", "George", "Tom"]
String[] lastNames = ["Dylan", "Lynne", "Orbison", "Harrison", "Petty"]

for(int i = 0; i < firstNames.size(); i++){
    User u = new User(firstName: firstNames[i], lastName: lastNames[i]);
    println("UserName is ${u.UserName()}");
}