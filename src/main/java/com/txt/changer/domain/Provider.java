package com.txt.changer.domain;

import java.io.*;
import java.util.concurrent.Callable;

public class Provider implements Runnable/*Callable<String>*/{

    private String myText;
    private TextHandler textHandler;
    private Worker worker;
    private String hash;
    private WorkStarter starter;

    public Provider(TextHandler textHandler, Worker worker, WorkStarter starter) {
        this.textHandler = textHandler;
        this.worker = worker;
        this.starter = starter;
    }

    public void run(){
        while (true) {
            this.myText = readData();
            worker.setText(myText);

            this.hash = this.starter.startWorker(this.worker);
            System.out.println("\n" + Thread.currentThread().toString() + "\n" + hash);
            this.writeData(hash);
        }
    }

//    public String call() throws Exception {
//            this.myText = readData();
//            worker.setText(myText);;
//            this.hash = this.starter.startWorker(this.worker);
//            this.writeData(hash);
//
//            return myText;
//    }

    public String readData(){
        this.textHandler.readData();
        return textHandler.getText();
    }

    public void writeData(String hash){
        this.textHandler.writeData(hash);
    }



    public TextHandler getTextHandler() {
        return textHandler;
    }

    public String getMyText() {
        return myText;
    }

    public void setMyText(String myText) {
        this.myText = myText;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public WorkStarter getStarter() {
        return starter;
    }

    public void setStarter(WorkStarter starter) {
        this.starter = starter;
    }
}
