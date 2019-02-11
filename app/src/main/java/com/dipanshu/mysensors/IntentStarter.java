package com.dipanshu.mysensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class IntentStarter extends  AppCompatActivity implements SensorEventListener {

    SensorManager sm1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentstarter);

        TextView textView = findViewById(R.id.name);

        textView.setText(getIntent().getStringExtra("name"));

//        sm1= (SensorManager) getSystemService(SENSOR_SERVICE);
//        List<Sensor> sen = sm1.getSensorList(Sensor.TYPE_ALL);
//
//        Log.e("position",":"+getIntent().getStringExtra("position"));
//
//        Sensor sm= sm1.getDefaultSensor(Integer.parseInt(getIntent().getStringExtra("position")));
//        sm1.registerListener(this,sm,SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

//        TextView textView = findViewById(R.id.value);
//        String abc="";
//        float[] sensorvalue=event.values;
//        for(float a : sensorvalue){
//            abc=abc+a;
//        }
//        textView.setText(abc);
        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
