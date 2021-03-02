String getUserName(String firstName, String lastName) {
    return firstName.substring(0,1).toLowerCase() + "_" + lastName.toLowerCase();
}

assert getUserName("Chris", "Behrens") == "c_behrens" : "getUserName isn't working"

//println(getUserName("Chris", "Behrens"))

void printCredential(cred){
    println("UserName is ${cred}")
}

String[] firstNames = ["Bob", "Jeff", "Roy", "George", "Tom"]
String[] lastNames = ["Dylan", "Lynne", "Orbison", "Harrison", "Petty"]

//printCredentials(getUserName("Chris", "Behrens"))
for(int i = 0; i < firstNames.size(); i++){
    printCredential(getUserName(firstNames[i], lastNames[i]));
}
