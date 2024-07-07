package Project2;
import Project.FileOperations;
import Project.FileOperations1;

import java.util.Scanner;
public class FileManager {
    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations1();
        Scanner in = new Scanner(System.in);
        boolean ongo = true;
        while(ongo){
            System.out.println("Enter command:");
            String cmnd = in.nextLine();
            String[] components = cmnd.split(" ");
            if(components.length<3){
                System.out.println("Error, enter command one more time.");
            }
            String command = components[0];
            String answer;
            switch(command){
                case "create":
                    if(components.length!=3){
                        answer = "Error, enter command one more time";
                    }
                    else{
                        String fileName = components[1];
                        String directoryPath = components[2];
                        new Create().doSmth(fileName, directoryPath);
                        answer = "Done, file " + fileName + " is created.";
                    }
                    break;
                case "delete":
                    if(components.length!=3){
                        answer = "Error, enter command one more time";
                    }
                    else{
                        String fileName = components[1];
                        String directoryPath = components[2];
                        new Delete().doSmth(fileName, directoryPath);
                        answer = "Done, file " + fileName + " is deleted.";

                    }
                    break;
                case "rename":
                    if(components.length!=4){
                        answer = "Error, enter command one more time";
                    }
                    else{
                        String directoryPath = components[1];
                        String oldName = components[2];
                        String newName = components[3];
                        new Rename().doSmth(directoryPath, oldName, newName);
                        answer = "Done, file " + oldName + " is renamed. New name is " + newName;
                    }
                    break;
                case "Copy":
                    if(components.length!=4){
                        answer = "Error, enter command one more time";
                    }
                    else{
                        String fileName = components[1];
                        String copy = components[2];
                        String paste = components[3];
                        new Copy().doSmth(fileName, copy, paste);
                        answer = fileOperations.copyFile(fileName, copy, paste);
                    }
                    break;

            }
        }
    }
}
