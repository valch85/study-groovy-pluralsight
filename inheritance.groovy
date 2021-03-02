abstract class User{
    String lastName;
    String firstName;

    public String UserName(){
        return getUserName(this.firstName, this.lastName);
    }

    private String getUserName(String firstName, String lastName) {
        return firstName.substring(0,1).toLowerCase() + "_" + lastName.toLowerCase();
    }
}

class Artist extends User {
    public String[] Songs;
}
class Producer extends User {
    public void Produce(){
        println("Album Complete");
    };
}

User[] users = [new Artist(firstName: "Bob", lastName: "Dylan", Songs: ["1st song", "2nd song"]),
                new Producer(firstName: "Jeff", lastName: "Lynne"),
                new Artist(firstName: "Roy", lastName: "Orbison", Songs: ["6th song"]),
                new Artist(firstName: "George", lastName: "Harrison", Songs: ["67th song"]),
                new Artist(firstName: "Tom", lastName: "Petty", Songs: ["8th song"])];


//users.each(user -> println("UserName is ${user.UserName()}"));
users.each{user ->
    if (user instanceof Artist) {
        println("UserName is ${user.UserName()}")
        user.Songs.each {
            println("${it}");
        }
    } else {
        user.Produce();
    }
};