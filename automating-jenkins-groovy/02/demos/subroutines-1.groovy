String getUserName(String firstName, String lastName){
    return firstName.substring(0,1).toLowerCase() + lastName.toLowerCase();
}

assert getUserName("Chris", "Behrens") == "cbehrens" : "getUserName isn't working"

println(getUserName("Chris", "Behrens"))

void printCredential(cred){
    println("UserName is ${cred}");
}

printCredential(getUserName("Chris", "Behrens"));