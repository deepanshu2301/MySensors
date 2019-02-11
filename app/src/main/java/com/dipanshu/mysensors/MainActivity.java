package com.dipanshu.mysensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{


    ArrayList<String> sensornames=new ArrayList<>();
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor>list =sm.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s :list){
            Log.e("TAG",":"+s.toString());
            String name=s.getName();
            sensornames.add(name);
        }

        Log.e("SIZE",":"+sensornames.size());

        TextView textView = findViewById(R.id.total);
        textView.setText(textView.getText().toString()+sensornames.size());
        ListView listView = findViewById(R.id.rvview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
          this,R.layout.sensor,R.id.parsensor,sensornames
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,sensornames.get(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(),IntentStarter.class);
                intent.putExtra("name",sensornames.get(position));
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
