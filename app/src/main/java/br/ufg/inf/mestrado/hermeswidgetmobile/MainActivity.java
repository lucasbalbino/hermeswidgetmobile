package br.ufg.inf.mestrado.hermeswidgetmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
}
