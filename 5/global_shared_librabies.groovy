import java.io.*;
import groovy.io.*;

def dir = new File("../4/ConsoleApp1"); //pwd();

dir.eachFileRecurse(FileType.ANY){file -> println(file.name + '\t' + file.length());}
