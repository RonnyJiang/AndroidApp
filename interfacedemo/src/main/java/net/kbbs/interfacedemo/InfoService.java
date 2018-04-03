package net.kbbs.interfacedemo;

import net.kbbs.interfacedemo.callback.OnInfoFetchCallback;

import java.util.Date;

/**
 * Created by ronny on 18-4-3.
 */

public class InfoService {
    private OnInfoFetchCallback callback;
    public InfoService(OnInfoFetchCallback callback) {
        this.callback = callback;
    }

    public void getInfo() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    callback.onSuccess("子线程over,开始回调接口:" + new Date());
                } catch (InterruptedException e) {
                    callback.onFailure();
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }
}
