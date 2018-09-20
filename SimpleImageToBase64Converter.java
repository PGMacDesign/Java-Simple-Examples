package com.pgmacdesign;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

public class MyConverterTestMain {
    public static void main(String[] args){
        try {
            String inputFileName = null;
            try {
                System.out.println("Please provide the full file path + extension to the image.\n IE: " +
                        "C:\\Users\\user\\Downloads\\some_folder\\a picture of a flower.jpeg");
                Scanner myScanner = new Scanner(System.in);
                inputFileName = myScanner.nextLine();
            } catch (Exception e){
                e.printStackTrace();
            }
            if(inputFileName == null){
                System.out.println("No file specified; exiting program");
                return;
            }
            File file = new File(inputFileName);
            FileInputStream fis = new FileInputStream(file);
            byte byteArray[] = new byte[(int)file.length()];
            fis.read(byteArray);
            String base64 = Base64.getEncoder().encodeToString(byteArray);
            FileWriter fileWriter = new FileWriter(inputFileName + "_Base64_Converted.txt");
//            FileOutputStream fos = new FileOutputStream(BASE_URL_MAIN + CLIENT_IMAGE_1 + "NEW_TEXT.txt");
//            byteArray = Base64.decodeBase64(imageString);
//            fos.write(base64);
//            fis.close();
//            fos.close();
            fileWriter.write(base64);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
