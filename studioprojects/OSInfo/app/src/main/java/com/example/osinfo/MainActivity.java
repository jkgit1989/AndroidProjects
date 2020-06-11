package com.example.osinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.*;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    Button btn;

    HardwarePropertiesManager hwpm = (HardwarePropertiesManager) getSystemService(this.HARDWARE_PROPERTIES_SERVICE);
    CpuUsageInfo cpuUsage[] = hwpm.getCpuUsages();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

    }

    public void GetOsInfo(View view) {

        tv.setText(String.format("cpuUsage length: %d", cpuUsage.length));
        for (CpuUsageInfo coreUsage : cpuUsage)
        {
            tv_tmp = (TextView) new TextView(this);
            String cpu_tmp = String.format("%d / %d", coreUsage.getActive(), coreUsage.getTotal());
            Log.i("mainActivity",cpu_tmp);
            tv_tmp.setText(cpu_tmp);
            lv.addView(tv_tmp);
        }
    }
}
