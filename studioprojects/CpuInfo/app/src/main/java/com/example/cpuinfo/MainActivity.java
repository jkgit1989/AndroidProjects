package com.example.cpuinfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.*;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static Context context;
    private static CpuUsageInfo cpuUsage[];

    TextView tv;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = getApplicationContext();

        HardwarePropertiesManager hwpm = (HardwarePropertiesManager) context.getSystemService(this.HARDWARE_PROPERTIES_SERVICE);
        cpuUsage = hwpm.getCpuUsages();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

    }

    public void GetOsInfo(View view) {

        tv.setText(String.format("cpuUsage length: %d", cpuUsage.length));
        for (CpuUsageInfo coreUsage : cpuUsage) {
            String cpu_tmp = String.format("%d / %d", coreUsage.getActive(), coreUsage.getTotal());
            Log.i("mainActivity", cpu_tmp);
            tv.setText(cpu_tmp);
        }
    }
}
