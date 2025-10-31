package com.example.mbti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class History extends AppCompatActivity {

    public RecordResult recordresult = new RecordResult();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        String 診断履歴="";
        Context context=getApplicationContext();
        String paste = recordresult.ReturnResult(context);
        if(paste.equals("")){
            診断履歴="診断履歴がありません";
        }else{
            診断履歴=paste;
        }
        ((TextView) findViewById(R.id.recordtext)).setText(診断履歴);

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordresult.DeleteResult(context);
                ((TextView) findViewById(R.id.recordtext)).setText("診断履歴がありません");
            }
        });
        findViewById(R.id.returnbut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}