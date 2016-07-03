package com.example.rsc.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imgbtnGueros;
    ImageButton imgbtnMercado;
    ImageButton imgbtnMetro;
    ImageButton imgbtnPortal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgbtnGueros = (ImageButton) findViewById(R.id.imgbtnGueros);
        imgbtnMercado = (ImageButton) findViewById(R.id.imgbtnMercado);
        imgbtnMetro = (ImageButton) findViewById(R.id.imgbtnMetro);
        imgbtnPortal = (ImageButton) findViewById(R.id.imgbtnPortal);
    }

    public void irMapa (View v){
        Log.v("id", String.valueOf(v.getId()));
        double latitud = 0;
        double longitud = 0;
        String lugar = "";
        switch (v.getId()){
            case R.id.imgbtnGueros:
                latitud = 19.3614659;
                longitud = -99.116826;
                lugar = getResources().getString(R.string.gueros);
                break;
            case R.id.imgbtnMercado:
                latitud = 19.362611;
                longitud = -99.112047;
                lugar = getResources().getString(R.string.mercado);
                break;
            case R.id.imgbtnMetro:
                latitud = 19.364372;
                longitud = -99.109418;
                lugar = getResources().getString(R.string.metro);
                break;
            case R.id.imgbtnPortal:
                latitud = 19.3685276;
                longitud = -99.1222891;
                lugar = getResources().getString(R.string.portal);;
                break;
            default:
                latitud = 0;
                longitud = 0;
                lugar = "";

        }
        Log.v("latitud",String.valueOf(latitud));
        Log.v("longitud", String.valueOf(longitud));
        Log.v("lugar", String.valueOf(lugar));
        Intent i = new Intent(this, MapsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("lugar",lugar);
        bundle.putDouble("latitud", latitud);
        bundle.putDouble("longitud", longitud);
        i.putExtras(bundle);
        startActivity(i);
    }
}
