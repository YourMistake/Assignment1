package com.example.erik.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends Activity {

    private TextView mTextView;
    private Button mbtnHit;
    private Button mbtnClear;
    private Button mbtnSave;
    private int Counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.txtDisplay);
                mbtnHit = (Button) stub.findViewById(R.id.btnHit);
                mbtnClear = (Button) stub.findViewById(R.id.btnClear);
                mbtnSave = (Button) stub.findViewById(R.id.btnSave);

                mTextView.setText(String.valueOf(Counter));

                mbtnHit.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Counter++;
                        mTextView.setText(String.valueOf(Counter));

                    }
                });

                mbtnClear.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Counter = 0;
                        mTextView.setText(String.valueOf(Counter));

                    }
                });

            }
        });
    }
}
