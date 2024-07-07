package Project2;

import java.io.File;
import java.io.IOException;

public class Create {
    public String fileName;
    public String directoryPath;

    public Create() {
    }

    public Create(String fileName, String directoryPath) {
        this.fileName = fileName;
        this.directoryPath = directoryPath;
    }


    public void doSmth(String fileName, String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error, enter command one more time");

        }
        else{
            File file = new File(dir, fileName);
            int counter = 1;
            while (file.exists()) {
                String newName = fileName.substring(0, fileName.lastIndexOf('.')) + "-" + counter + fileName.substring(fileName.lastIndexOf('.'));
                file = new File(dir, newName);
                counter++;
            }

            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("Done, file " + file.getName() + " is created.");
                } else {
                    System.out.println("Error, enter command one more time");
                }
            } catch (IOException e) {
                System.out.println("Error, enter command one more time");
            }
        }

    }
}
