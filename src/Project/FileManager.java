package Project;
import java.util.Scanner;
public class FileManager {
    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations1();
        Scanner in = new Scanner(System.in);
        while(true){
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
                        answer = fileOperations.createFile(fileName, directoryPath);
                    }
                    break;
                case "delete":
                    if(components.length!=3){
                        answer = "Error, enter command one more time";
                    }
                    else{
                        String fileName = components[1];
                        String directoryPath = components[2];
                        answer = fileOperations.deleteFile(fileName, directoryPath);

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
                        answer = fileOperations.renameFile(directoryPath, oldName, newName);
                    }
                    break;
                case "copy":
                    if(components.length!=4){
                        answer = "Error, enter command one more time";
                    }
                    else{
                        String fileName = components[1];
                        String copy = components[2];
                        String paste = components[3];
                        answer = fileOperations.copyFile(fileName, copy, paste);
                    }
                    break;
                default:
                    answer = "Error, enter command one more time";
            }
            System.out.println(answer);
        }
    }
}
