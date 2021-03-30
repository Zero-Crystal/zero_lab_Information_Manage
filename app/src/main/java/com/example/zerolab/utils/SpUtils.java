package com.example.zerolab.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author zero
 */
public class SpUtils {

    public static void putString(Context context,String key,String value){
        SharedPreferences.Editor editor=context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static void putInt(Context context,String key,int value){
        SharedPreferences.Editor editor=context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public static void putBoolean(Context context,String key,Boolean value){
        SharedPreferences.Editor editor=context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public static void getString(Context context,String key,String defValue){
        SharedPreferences editor=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor.getString(key,defValue);
    }

    public static void getInt(Context context,String key,int defValue){
        SharedPreferences editor=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor.getInt(key,defValue);
    }

    public static void getBoolean(Context context,String key,Boolean defValue){
        SharedPreferences editor=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        editor.getBoolean(key,defValue);
    }
}
