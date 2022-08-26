package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {
    private static final String path = "assets/";

    public static File loadFile(String filePath) throws IOException {
        File file = new File(path + filePath);

        // Safeguard
        if(!file.exists()) {
            throw new IOException();
        }

        return file;
    }

    public static void saveTextToFile(String filePath, String textToSave) throws IOException {
        Path file = Paths.get(path + filePath);

        Files.write(file, textToSave.getBytes(), StandardOpenOption.APPEND);
    }
}
