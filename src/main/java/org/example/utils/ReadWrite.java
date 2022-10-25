package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ReadWrite {
    public static String readFile(String filePath) {
        String fileContent = null;

        try {
            Path path = Paths.get(filePath);
            fileContent = Files.readString(path);
            // The method, readString(), ensures that the file is closed when all content have been read
            // or an I/O error, or other runtime exception, is thrown.
            // So, no need to close it explicitly
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (Objects.isNull(fileContent)) {
                System.out.println(String.format("Given file %s was not read!", filePath));
            }
        }

        return fileContent;
    }
}
