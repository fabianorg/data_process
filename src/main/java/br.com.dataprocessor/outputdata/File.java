package br.com.dataprocessor.outputdata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {

    private static String outputFile = System.getProperty("user.home")
            .concat("/data/out/");

    public static void save(String data, String name) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile+name+"-out"));
        writer.write(data);
        writer.close();
    }
}

