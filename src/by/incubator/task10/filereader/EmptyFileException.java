package by.incubator.task10.filereader;


public class EmptyFileException extends Exception {

    private String filePath;

    public EmptyFileException(String message, String filepath) {
        super(message);
        this.filePath = filepath;
    }

    public EmptyFileException(String message, Throwable cause, String filePath) {
        super(message, cause);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
