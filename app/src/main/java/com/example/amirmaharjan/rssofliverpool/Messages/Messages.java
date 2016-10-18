package com.example.amirmaharjan.rssofliverpool.Messages;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Amir Maharjan on 10/18/2016.
 */

public class Messages {
    public static void toast(Context context, String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
    public static void log(String tag,String message)
    {
        Log.d(tag,message);
    }
}
