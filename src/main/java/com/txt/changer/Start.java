package com.txt.changer;

import com.txt.changer.domain.Provider;
import com.txt.changer.domain.TextHandler;
import com.txt.changer.domain.WorkStarter;
import com.txt.changer.domain.Worker;

import java.util.concurrent.*;

public class Start {


    private static int n = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TextHandler textHandler = new TextHandler();
        Worker worker = new Worker();
        WorkStarter starter = new WorkStarter();

        Provider provider1 = new Provider(textHandler, worker, starter);
        Provider provider2 = new Provider(textHandler, worker, starter);
        Provider provider3 = new Provider(textHandler, worker, starter);
        ExecutorService service = Executors.newFixedThreadPool(n);

        service.submit(provider1);
        service.submit(provider2);
        service.submit(provider3);



//        while (true){
//            readWriteData(provider1, worker, service);
//            readWriteData(provider2, worker, service);
//            readWriteData(provider3, worker, service);
//        }

    }

//    private static void readWriteData(Provider provider, Worker worker, ExecutorService service) {
//        try {
//            Future<String> future = service.submit(provider);
//            String fileText = future.get();
//            worker.setText(fileText);
//            Future<String> futureHash = service.submit(worker);
//            String fileHash = futureHash.get();
//            String fileHash = worker.getHash();
//            provider.writeData(fileHash);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }

}
