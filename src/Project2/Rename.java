package Project2;

import java.io.File;
public class Rename{

    public void doSmth(String directoryPath, String oldName, String newName) {
        File oldFile = new File(directoryPath, oldName);
        if (!oldFile.exists()) {
            System.out.println("Error, file is not found.");
        }
        else{
            File newFile = new File(directoryPath, newName);
            boolean renamed = oldFile.renameTo(newFile);
            if (renamed) {
                System.out.println("Done, file " + oldName + " is renamed. New name is " + newName);
            } else {
                System.out.println("Error, enter command one more time");
            }
        }

    }
}
