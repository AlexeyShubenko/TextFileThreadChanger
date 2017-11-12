package com.txt.changer.domain;

import java.util.concurrent.Callable;

public class Worker implements Callable<String>{

    private String text;
    private String  hash;

    public String call() throws Exception {
        hash = hashCalculation(this.text);
        return hash;
    }

    public synchronized String hashCalculation(String text){
        return "SHA"+(text.hashCode()/17);
    }


    public void setText(String text) {
        this.text = text;
    }

}
