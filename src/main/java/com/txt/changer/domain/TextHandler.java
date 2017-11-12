package com.txt.changer.domain;

import java.io.*;

public class TextHandler {

    private String text;

    //read data from file
    public synchronized void readData()  {
        try {
            File file = new File("file.txt");
            FileInputStream fis = new FileInputStream(file);
            StringBuffer stringBuffer = new StringBuffer();
            while (fis.available()>0){
                stringBuffer.append((char)fis.read());
            }
            this.text = stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write data to file
    public synchronized void writeData(String hash)  {
        try {
            File file = new File("file.txt");
            FileWriter fos = new FileWriter(file,true);
            fos.write("\n"+hash);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getText() {
        return text;
    }
}
