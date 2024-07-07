package Project2;

public interface FileOperations {
    abstract void doSmth();


    abstract void doSmth(String fileName, String directoryPath);

    abstract void doSmth(String directoryPath, String oldName, String newName);


}
