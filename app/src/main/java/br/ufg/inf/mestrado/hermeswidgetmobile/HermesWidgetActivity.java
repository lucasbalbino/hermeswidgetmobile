package br.ufg.inf.mestrado.hermeswidgetmobile;

import android.content.res.AssetManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import br.ufg.inf.mestrado.hermeswidget.client.sensor.bloodPressure.HWSensorBloodPressure;
import br.ufg.inf.mestrado.hermeswidget.client.sensor.heartRate.HWSensorHeartRate;
import br.ufg.inf.mestrado.hermeswidget.client.sensor.oxygenSaturation.HWSensorOxygenSaturation;
import br.ufg.inf.mestrado.hermeswidget.client.sensor.respiratoryRate.HWSensorRespiratoryRate;
import br.ufg.inf.mestrado.hermeswidget.client.sensor.temperature.HWSensorTemperature;

public class HermesWidgetActivity extends AppCompatActivity {
    double estimatedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hermes_widget);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.estimatedTime = 0;

        String type = getIntent().getStringExtra("HWType");

        String args[] = new String[3];

        // QUANTIDADE DE TUPLAS A SEREM PROCESSADAS
        args[0] = "10";  // MAXIMO DE TUPLAS: 34540

        // INTERVALO ENTRE AS TUPLAS
        args[1] = "1"; // DEFAULT = 1

        // QUANTIDADE DE REPRESENTAÇÕES OntModel EM CACHE
        args[2] = "7";

        String arquivo = "041n.csv";

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(sensorRecord(args, arquivo, type));

        TextView textWidget = (TextView) findViewById(R.id.textView5);
        textWidget.setText(type);

        TextView textArg0 = (TextView) findViewById(R.id.textView7);
        textArg0.setText(args[0]);
        TextView textArg1 = (TextView) findViewById(R.id.textView9);
        textArg1.setText(args[1]);
        TextView textArg2 = (TextView) findViewById(R.id.textView11);
        textArg2.setText(args[2]);

        TextView textEstimatedTime = (TextView) findViewById(R.id.textView2);
        String time = this.estimatedTime + " s";
        textEstimatedTime.setText(time);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String sensorRecord(String args[], String arquivo, String type) {
        long startTime = System.currentTimeMillis();
        Log.e("HW", "HERMES WIDGET Inicializado!!!!");
        String record = "";

        AssetManager assetManager = getAssets();
        InputStream registroMimic = null;
        try {
            registroMimic = assetManager.open("mimic/paciente-teste/" + arquivo);
        } catch (IOException e) {
            Log.e("message: ", e.getMessage());
        }

        if(type.equals("BloodPressure")) {
            HWSensorBloodPressure widget = new HWSensorBloodPressure(registroMimic, arquivo, args);
            record = widget.getRecordRDF().toString();
        } else if(type.equals("HeartRate")) {
            HWSensorHeartRate widget = new HWSensorHeartRate(registroMimic, arquivo, args);
            record = widget.getRecordRDF().toString();
        } else if(type.equals("OxygenSaturation")) {
            HWSensorOxygenSaturation widget = new HWSensorOxygenSaturation(registroMimic, arquivo, args);
            record = widget.getRecordRDF().toString();
        }else if(type.equals("Temperature")) {
            HWSensorTemperature widget = new HWSensorTemperature(registroMimic, arquivo, args);
            record = widget.getRecordRDF().toString();
        } else if(type.equals("RespiratoryRate")) {
            HWSensorRespiratoryRate widget = new HWSensorRespiratoryRate(registroMimic, arquivo, args);
            record = widget.getRecordRDF().toString();
        }

        Log.e("HW", "HERMES WIDGET FINALIZADO!!!!");
        estimatedTime = (System.currentTimeMillis() - startTime)/1000.0;
        MainActivity.id = MainActivity.id +1;
        return record;
    }
}
