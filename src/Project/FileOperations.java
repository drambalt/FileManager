package Project;

public interface FileOperations {
    String createFile(String fileName, String directoryPath);
    String deleteFile(String fileName, String directoryPath);
    String renameFile(String directoryPath, String oldName, String newName);
    String copyFile(String fileName, String sourceDir, String targetDir);
}
