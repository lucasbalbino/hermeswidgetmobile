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
import java.util.concurrent.TimeUnit;

import br.ufg.inf.mestrado.hermeswidget.client.sensor.bloodPressure.HWSensorBloodPressure;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        AssetManager assetManager = getAssets();
        InputStream registroMimic = null;
        String nome = "";
        try {
            registroMimic = assetManager.open("mimic/paciente-teste/041n.csv");
            nome = "041n.csv";
        } catch (IOException e) {
            Log.e("message: ", e.getMessage());
        }

        Log.i("HERMES WIDGET", "Hermes Widget Sensor " + nome + " inicializado as " + new Date());

        String args[] = new String[2];
        args[0] = "1";
        args[1] = "1";


        ScheduledExecutorService poolWidgets = Executors.newScheduledThreadPool(Integer.parseInt(args[1]));

        HWSensorBloodPressure widget = new HWSensorBloodPressure(registroMimic, nome, args);

//        poolWidgets.schedule(widget, 2, TimeUnit.SECONDS);

    }
}
