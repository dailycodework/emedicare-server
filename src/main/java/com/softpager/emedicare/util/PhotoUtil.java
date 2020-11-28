package com.softpager.emedicare.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PhotoUtil{


    public static byte[] getImage() {
        File file = null;
        assert false;
        Path path = Paths.get(file.getAbsolutePath());
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
