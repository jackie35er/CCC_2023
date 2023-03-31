package org.jackie35er;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;

public class Writer {

    public static void write(Path path,String string) {
        try {
            Files.write(path, string.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @SneakyThrows
    public static void append(Path path, String string) {

        Files.writeString(path, string + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
