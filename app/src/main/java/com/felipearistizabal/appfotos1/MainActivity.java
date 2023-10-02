package com.felipearistizabal.appfotos1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamada, mapa, temporizador, segundaPantalla;
    String mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        segundaPantalla = findViewById(R.id.activity);
        google = findViewById(R.id.google);
        alarma = findViewById(R.id.alarma);
        llamada = findViewById(R.id.llamar);
        mapa = findViewById(R.id.mapaGps);
        temporizador = findViewById(R.id.temporizador);

        segundaPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaje = "Estás en la segunda pantalla";
                Intent enviarDatos = new Intent(MainActivity.this,segundaPantalla.class);
                enviarDatos.putExtra("textoSegundaP",mensaje);
                startActivity(enviarDatos);
            }
        });

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
            public void onClick(View v) {
                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE,"Boxeo");
                alarma.putExtra(AlarmClock.EXTRA_HOUR,5);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES,40);

                    startActivity(alarma);

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
                showMap(Uri.parse("geo:6.133,-75.25"));
            }
        });

        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer("Estudio",70);
            }
        });

    }


    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

            startActivity(intent);

    }
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

            startActivity(intent);
        
    }

}
