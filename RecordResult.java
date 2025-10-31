package com.example.mbti;

import static android.content.Context.MODE_PRIVATE;

import static java.security.AccessController.getContext;

import android.content.ContentValues;
import android.content.Context;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class RecordResult {

    String []性格記録 = new String[1000];
    String []日時記録 = new String[1000];
    int 診断数=0;


    private SharedPreferences dataStore;

    public void SaveResult(String 診断性格, String 診断時刻,Context context){

        dataStore = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = dataStore.edit();
        String 履歴 = dataStore.getString("rireki","");
        履歴=診断性格+"  --"+診断時刻 + "\n" + 履歴;
        editor.putString("rireki", 履歴);
        editor.apply();

    }

    public String ReturnResult(Context context){
        dataStore = PreferenceManager.getDefaultSharedPreferences(context);
        return dataStore.getString("rireki","");
    }

    public void DeleteResult(Context context){
        dataStore = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = dataStore.edit();
        editor.putString("rireki", "");
        editor.apply();

    }


}
