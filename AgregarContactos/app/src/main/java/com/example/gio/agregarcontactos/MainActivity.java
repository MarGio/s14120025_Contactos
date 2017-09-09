package com.example.gio.agregarcontactos;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button btn;
    Contacto cp;
    ListView LstV;
    ArrayAdapter Adapta;
    String Datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LstV=(ListView) findViewById(R.id.listV);
        btn= (Button)findViewById(R.id.btnNuevoContacto);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,NuevoContacto.class);
                i.putStringArrayListExtra("arreglo",Contactos);
                startActivityForResult(i,2);
            }
        });


    }
    ArrayList <String> Contactos=new ArrayList<>();
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RESULT_OK == resultCode) {
            Contacto cC;
            cC = (Contacto) data.getExtras().getSerializable("contacto");
            Contactos.add(cC.getUsuario()+" ----"+cC.getEmail()+" ---" +cC.getTwitter()+" ---"+cC.getTelefono()+"--- "+cC.getFecha());

            ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Contactos);
            LstV.setAdapter(adp);

        } else {

        }
    }
}
