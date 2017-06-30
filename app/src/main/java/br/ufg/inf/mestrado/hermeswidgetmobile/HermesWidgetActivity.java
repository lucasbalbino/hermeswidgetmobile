package br.ufg.inf.mestrado.hermeswidgetmobile;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import br.ufg.inf.mestrado.hermeswidget.client.sensor.bloodPressure.HWSensorBloodPressure;

public class HermesWidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hermes_widget);

        Intent intent = getIntent();

        String args[] = new String[3];

        // QUANTIDADE DE TUPLAS A SEREM PROCESSADAS
        args[0] = "500";  // MAXIMO DE TUPLAS: 34540

        // INTERVALO ENTRE AS TUPLAS
        args[1] = "1"; // DEFAULT = 1

        // QUANTIDADE DE REPRESENTAÇÕES OntModel EM CACHE
        args[2] = "100";

        String arquivo = "041n.csv";

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(sensorBloodPressureRecord(args, arquivo));
    }

    private String sensorBloodPressureRecord(String args[], String arquivo) {
        Log.e("HW", "HERMES WIDGET Inicializado!!!!");
        String record = "";

        AssetManager assetManager = getAssets();
        InputStream registroMimic = null;
        String nome = "";
        try {
            registroMimic = assetManager.open("mimic/paciente-teste/" + arquivo);
            nome = "041n.csv";
        } catch (IOException e) {
            //Log.e("message: ", e.getMessage());
        }

        //Log.i("HERMES WIDGET", "Hermes Widget Sensor " + nome + " inicializado as " + new Date());


        //ScheduledExecutorService poolWidgets = Executors.newScheduledThreadPool(Integer.parseInt(args[1]));

        HWSensorBloodPressure widget = new HWSensorBloodPressure(registroMimic, nome, args);

     // poolWidgets.schedule(widget, 2, TimeUnit.SECONDS);

        record = widget.getRecordRDF().toString();
        Log.e("HW", "HERMES WIDGET FINALIZADO!!!!");
        return record;
    }
}
