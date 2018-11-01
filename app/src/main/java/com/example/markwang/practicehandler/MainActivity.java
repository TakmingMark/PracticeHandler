package com.example.markwang.practicehandler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;
    private mHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        initObject();
        initListener();
    }

    private void initObject() {
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        handler=new mHandler();

    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        Message message = new Message();
                        message.what = 0;
                        handler.sendMessage(message);
                        Looper.loop();
                    }
                }).start();
            }
        });
    }
    class mHandler extends  Handler{
        @Override
        public void handleMessage(Message msg) {
            textView.setText("Handler set text");
        }
    }

}

