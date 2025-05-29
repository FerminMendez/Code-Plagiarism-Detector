package com.renoux.gael.codejam.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Pour tests unitaires
 * 
 * @author renouxg
 */
public final class FileUtils {

    public static File fromWorkspace(String path) throws URISyntaxException {
        ClassLoader.getSystemResource(path);
        URL url = FileUtils.class.getClassLoader().getResource(path);
        return new File(url.toURI());
    }

    public static BufferedReader getReader(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        return br;
    }

}
