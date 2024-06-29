package Project;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class FileOperations1 implements FileOperations {




    @Override
    public String createFile(String fileName, String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return "Error, enter command one more time";
        }
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
                return "Done, file " + file.getName() + " is created.";
            } else {
                return "Error, enter command one more time";
            }
        } catch (IOException e) {
            return "Error, enter command one more time";
        }
    }

    @Override
    public String deleteFile(String fileName, String directoryPath) {
        File file = new File(directoryPath, fileName);
        if (!file.exists()) {
            return "Error, file is not found.";
        }
        boolean deleted = file.delete();
        if (deleted) {
            return "Done, file " + fileName + " is deleted.";
        } else {
            return "Error, enter command one more time";
        }
    }

    @Override
    public String renameFile(String directoryPath, String oldName, String newName) {
        File oldFile = new File(directoryPath, oldName);
        if (!oldFile.exists()) {
            return "Error, file is not found.";
        }

        File newFile = new File(directoryPath, newName);
        boolean renamed = oldFile.renameTo(newFile);
        if (renamed) {
            return "Done, file " + oldName + " is renamed. New name is " + newName;
        } else {
            return "Error, enter command one more time";
        }
    }

    @Override
    public String copyFile(String fileName, String sourceDir, String targetDir) {
        File sourceFile = new File(sourceDir, fileName);
        if (!sourceFile.exists()) {
            return "Error, file is not found.";
        }

        File targetDirectory = new File(targetDir);
        if (!targetDirectory.exists() || !targetDirectory.isDirectory()) {
            return "Error, enter command one more time";
        }

        File targetFile = new File(targetDirectory, fileName);
        int counter = 1;
        while (targetFile.exists()) {
            String newName = fileName.substring(0, fileName.lastIndexOf('.')) + "-" + counter + fileName.substring(fileName.lastIndexOf('.'));
            targetFile = new File(targetDirectory, newName);
            counter++;
        }

        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "Done, file " + targetFile.getName() + " is copied.";
        } catch (IOException e) {
            return "Error, enter command one more time";
        }
    }
}
