package com.heyflyer.heyflyersdk.rest_api;

import android.util.Log;

import java.io.IOException;
import java.net.SocketException;


public class ApiErrorUtils {

    static String TAG = ApiErrorUtils.class.getSimpleName();
    public static final String ERROR_NETWORK = "NETWORK PROBLEM";
    public static final String CONNECTION_TIMEOUT = "CONNECTION TIMEOUT";
    public static final String SOMETHING_WENT_WRONG = "INTERNAL ERROR";

    public static String getErrorMsg(Throwable t)
    {
        if(t instanceof IOException)
        {
            Log.e(TAG, ERROR_NETWORK);
            return ERROR_NETWORK;
        }
        else if(t instanceof SocketException)
        {
            Log.e(TAG, CONNECTION_TIMEOUT);
            return CONNECTION_TIMEOUT;
        }
        else
        {
            Log.e(TAG, t.toString());
            return SOMETHING_WENT_WRONG;
        }
    }
}
