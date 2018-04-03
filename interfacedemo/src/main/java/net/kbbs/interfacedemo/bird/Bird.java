package net.kbbs.interfacedemo.bird;

import android.util.Log;
import android.util.TimeFormatException;

/**
 * Created by ronny on 18-4-3.
 */

public class Bird implements MyInterface1, MyInterface2, BirdInfo{
    private static final String TAG = "RonnyBird";
    @Override
    public void fly() {
        Log.i(TAG, "I can fly!");
    }

    @Override
    public void walk() {
        Log.i(TAG, "I can walk");
    }


    @Override
    public void getBirdInfo() {
        Log.i(TAG, "I am "+name+" , my id is "+ id);
    }
}
