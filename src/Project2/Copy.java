package Project2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Copy {

    public void doSmth(String fileName, String sourceDir, String targetDir) {
        File sourceFile = new File(sourceDir, fileName);
        if (!sourceFile.exists()) {
            System.out.println("Error, file is not found.");
        }
        else{
            File targetDirectory = new File(targetDir);
            if (!targetDirectory.exists() || !targetDirectory.isDirectory()) {
                System.out.println("Error, enter command one more time");
            }
            else{
                File targetFile = new File(targetDirectory, fileName);
                int counter = 1;
                while (targetFile.exists()) {
                    String newName = fileName.substring(0, fileName.lastIndexOf('.')) + "-" + counter + fileName.substring(fileName.lastIndexOf('.'));
                    targetFile = new File(targetDirectory, newName);
                    counter++;
                }

                try {
                    Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Done, file " + targetFile.getName() + " is copied.");
                } catch (IOException e) {
                    System.out.println("Error, enter command one more time");
                }
            }
        }



    }
}
