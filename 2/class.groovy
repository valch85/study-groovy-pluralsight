class User{
    String lastName;
    String firstName;

    public String UserName(){
        return getUserName(this.firstName, this.lastName);
    }

    private String getUserName(String firstName, String lastName) {
        return firstName.substring(0,1).toLowerCase() + "_" + lastName.toLowerCase();
    }
}

/*
String[] firstNames = ["Bob", "Jeff", "Roy", "George", "Tom"]
String[] lastNames = ["Dylan", "Lynne", "Orbison", "Harrison", "Petty"]

for(int i = 0; i < firstNames.size(); i++){
    User u = new User(firstName: firstNames[i], lastName: lastNames[i]);
    println("UserName is ${u.UserName()}");
}

*/

User[] users = [new User(firstName: "Bob", lastName: "Dylan"),
                new User(firstName: "Jeff", lastName: "Lynne"),
                new User(firstName: "Roy", lastName: "Orbison"),
                new User(firstName: "George", lastName: "Harrison"),
                new User(firstName: "Tom", lastName: "Petty")];

//1st variant
users.each(user -> println("UserName is ${user.UserName()}"));
//2nd variant
users.each{println("UserName is ${it.UserName()}")};


