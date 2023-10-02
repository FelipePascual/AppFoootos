package com.felipearistizabal.appfotos1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamada, mapa, temporizador, segundaPantalla;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);
        mapa = findViewById(R.id.mapaGps);
        temporizador = findViewById(R.id.temporizador);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
                irAGoogle.setData(Uri.parse("http://www.google.com"));
                startActivity(irAGoogle);
            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "Gimnasio");
                alarma.putExtra(AlarmClock.EXTRA_HOUR, 5);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);
                if(alarma.resolveActivity(getPackageManager())!=null){
                    startActivity(alarma);
                }
            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("3026069616");
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri geoLocation = Uri.parse("geo:6.133,-75.25?q=Santuario");
                showMap(geoLocation);
            }
        });

        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
