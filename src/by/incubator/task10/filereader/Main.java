package by.incubator.task10.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static final String CORRECT_PATH = "./src/input.txt";
    public static final String INCORRECT_FILE_PATH = "./src/not_input.txt";
    public static final String EMPTY_FILE_PATH = "./src/empty.txt";

    public static void readFile(String path) throws EmptyFileException{
        File file = new File(path);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             Scanner in = new Scanner(fileInputStream)){

            String fileLine = in.nextLine();

            System.out.printf("'%s' was read from file '%s'%n", fileLine, path );

        } catch (IOException | NoSuchElementException e) {
            throw new EmptyFileException("File '" + path + "' is empty", e, path);
        } finally {
            System.out.println("finally method for '" + path + "'");
        }
    }

    public static void main(String[] args) {

        try {
            readFile(CORRECT_PATH);
            readFile(INCORRECT_FILE_PATH);

        } catch (EmptyFileException ignore) {
        }


        System.out.println();

        try {
            readFile(CORRECT_PATH);
            readFile(EMPTY_FILE_PATH);
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }

        System.out.println("\nReading not existing file:");
        try {
            readFile(INCORRECT_FILE_PATH);
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }
    }
}
