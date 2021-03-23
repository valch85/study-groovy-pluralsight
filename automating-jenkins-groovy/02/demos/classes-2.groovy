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

User[] users = [new User(firstName: "Bob", lastName: "Dylan"),
                new User(firstName: "Jeff", lastName: "Lynne"),
                new User(firstName: "Roy", lastName: "Orbison"),
                new User(firstName: "George", lastName: "Harrison"),
                new User(firstName: "Tom", lastName: "Petty")];

users.each(user -> println("UserName is ${user.UserName()}"));