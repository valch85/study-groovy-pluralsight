import java.io.*;
import groovy.io.*;

def dir = new File("../ConsoleApp"); //pwd();

new File(dir.path + '/releasenotes.txt').withWriter('utf-8'){
    writer -> 
        dir.eachFileRecurse(FileType.ANY){file ->
            if (file.isDirectory()){
                writer.writeLine(file.name);
            }
            else{
                writer.writeLine(file.name + '\t' + file.length());
            }
    }
}


