package br.ufg.inf.mestrado.hermeswidgetmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hp.hpl.jena.iri.impl.Main;
import com.hp.hpl.jena.ontology.OntModel;

public class MainActivity extends AppCompatActivity {
    private static OntModel[] cache = null;
    static int id = 0;

    public static void setCache(OntModel[] cache){MainActivity.cache = cache;}

    public static OntModel[] getCache() {return MainActivity.cache;}

    public static OntModel getCache(int index) {return MainActivity.cache[index];}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarHWBloodPressure(View view) {
        Intent intent = new Intent(this, HermesWidgetActivity.class).putExtra("HWType", "BloodPressure");
        startActivity(intent);
    }

    public void iniciarHWHeartRate(View view) {
        Intent intent = new Intent(this, HermesWidgetActivity.class).putExtra("HWType", "HeartRate");
        startActivity(intent);
    }

    public void iniciarHWOxygenSaturation(View view) {
        Intent intent = new Intent(this, HermesWidgetActivity.class).putExtra("HWType", "OxygenSaturation");
        startActivity(intent);
    }

    public void iniciarHWRespiratoryRate(View view) {
        Intent intent = new Intent(this, HermesWidgetActivity.class).putExtra("HWType", "RespiratoryRate");
        startActivity(intent);
    }

    public void iniciarHWTemperature(View view) {
        Intent intent = new Intent(this, HermesWidgetActivity.class).putExtra("HWType", "Temperature");
        startActivity(intent);
    }

    public void consultaCache(View view){
        Intent intent = new Intent(this, QueryActivity.class);
        startActivity(intent);
    }
}
