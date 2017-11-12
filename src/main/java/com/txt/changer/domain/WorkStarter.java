package com.txt.changer.domain;

import java.util.concurrent.*;

//class used for starting Worker
public class WorkStarter {

    private String fileHash;


    public WorkStarter() {
    }

    //start Worker and obtain file hash
    public synchronized String startWorker(Worker worker) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(1);
            Future<String>  fileHashFuture = service.submit(worker);
            this.fileHash = fileHashFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return this.fileHash;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }
}
