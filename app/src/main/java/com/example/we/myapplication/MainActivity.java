package com.example.we.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private ArrayList<String> mFileList;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout =  (LinearLayout) findViewById(R.id.main);

        getFileList(Environment.getExternalStorageDirectory() + "/barcode");

        for(String path : mFileList) {
            Button myButton = new Button(this);

            myButton.setText(Environment.getExternalStorageDirectory() + "/barcode" + "/" + path);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button)v;
                    startActivity(b.getText().toString());
                }
            });

            mLinearLayout.addView(myButton);
        }
    }

    public void getFileList(String strPath) {
        // 폴더 경로를 지정해서 File 객체 생성
        File fileRoot = new File(strPath);
        // 파일 목록을 구한다
        String[] fileList = fileRoot.list();
        mFileList = new ArrayList<String>();

        for(String path : fileList) {
            mFileList.add(path);
        }
    }

    private void startActivity(String path){
        Intent intent = new Intent(this , ImageActivity.class);
        intent.putExtra("PATH" , path);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
