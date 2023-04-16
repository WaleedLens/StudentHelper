package core.utils;

import java.io.IOException;

public class FileUtils {

    public static String getResourcesPath(){

        String path = ClassLoader.getSystemResource("").getPath();
        System.out.println("Path: " + path);
        return path;
    }
}
