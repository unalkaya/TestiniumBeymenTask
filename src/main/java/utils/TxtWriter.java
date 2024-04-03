package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtWriter {

    public static void writeProductToFile(String price, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(price);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
