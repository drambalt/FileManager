package Project2;

import java.io.File;
import java.io.File;
import java.io.IOException;

public class Delete {
    public String fileName;
    public String directoryPath;
    public Delete() {
    }

    public Delete(String fileName, String directoryPath) {
        this.fileName = fileName;
        this.directoryPath = directoryPath;
    }

    public void doSmth(String fileName, String directoryPath) {
        File file = new File(directoryPath, fileName);
        if (!file.exists()) {
            System.out.println("Error, file is not found.");
        }
        else{
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Done, file " + fileName + " is deleted.");
            } else {
                System.out.println("Error, enter command one more time");
            }
        }

    }
}
