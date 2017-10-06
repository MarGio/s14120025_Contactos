package com.example.gio.permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSION = 124;
    private final int REQUEST_ACCESS_FINE=0;
    int hasReadContactsPermission;


    private void accessPermission(){
        hasReadContactsPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
        if (hasReadContactsPermission != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},
                    REQUEST_CODE_ASK_PERMISSION);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permission, int [] grandResult){
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSION:
                if (grandResult[0]== PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Permiso concedido para leer los contactos",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Permiso denegado para leer los contactos",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permission, grandResult);
        }
        if (requestCode == REQUEST_ACCESS_FINE){
            if (grandResult.length > 0 && grandResult[0]
                    == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "Permiso concedido para Localizacion",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "Permiso denegado Localizacion",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    Button btnC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_ACCESS_FINE);
        btnC = (Button)findViewById(R.id.btnContacto);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessPermission();
            }
        });
    }
}
