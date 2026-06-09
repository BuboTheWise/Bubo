package com.bubo.app;

import android.util.Log;

public class Logger {
    private static final String TAG = "BuboApp";
    
    public static void debug(String message) {
        Log.d(TAG, message);
    }
    
    public static void info(String message) {
        Log.i(TAG, message);
    }
    
    public static void warn(String message) {
        Log.w(TAG, message);
    }
    
    public static void error(String message) {
        Log.e(TAG, message);
    }
    
    public static void error(String message, Throwable throwable) {
        Log.e(TAG, message, throwable);
    }
}