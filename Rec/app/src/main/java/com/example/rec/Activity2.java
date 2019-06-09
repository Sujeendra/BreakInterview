
package com.example.rec;


import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.InputStreamReader;
//Author Sujeendra R
public class Activity2 extends Activity {
    TextView textView;
    BufferedReader reader = null;
    static StringBuilder text=new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent =getIntent();
        String path=intent.getStringExtra("New");
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path)));
            String mline;
            while((mline=reader.readLine())!=null){
                text.append(mline);
                text.append("\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textView=findViewById(R.id.textView2);
        textView.setText(text);



    }
}