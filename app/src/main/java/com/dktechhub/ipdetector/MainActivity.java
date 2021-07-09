package com.dktechhub.ipdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView local,global,refresh;
    IpDetector ipDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        local=findViewById(R.id.localip);
        global=findViewById(R.id.globalip);
        refresh=findViewById(R.id.refresh);
        ipDetector=new IpDetector(this, new IpDetector.OnIpGet() {
            @Override
            public void localIp(String s, boolean isConnected) {
                if(isConnected)
                    local.setText(s);
                else local.setText("Not connected");
            }

            @Override
            public void globalIp(String s, boolean isConnected) {
                if(isConnected)
                    global.setText(s);
                else global.setText("Not connected");
            }
        });
        ipDetector.update();
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipDetector.update();
            }
        });
    }
}