package com.xl.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

public class AsyncService {

    @Async
    public void asyncMethodWithVoidReturnType(){
        System.out.println("Execute method asynchronously."
         + Thread.currentThread().getName()
        );
    }

    public Future<String> asynoMethodWithReturnType(){
        System.out.println("\"Execute method asynchronously - \"  + Thread.currentThread().getName()");

        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world");
        } catch (InterruptedException e) {

        }
        return null;
    }
    public static void main(String[] args) throws Exception {
       /* new AsyncService().asyncMethodWithVoidReturnType();*/
         Future<String> a = new AsyncService().asynoMethodWithReturnType();
        System.out.println(a.get());
    }
}
