package com.example.gio.agregarcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NuevoContacto extends AppCompatActivity {
Button btn;
EditText Usuario;
EditText Email;
EditText Twitter;
EditText Telefono;
EditText FechaNac;
Intent regreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);
        btn =(Button)findViewById(R.id.btnGuardar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NuevoContacto.this, MainActivity.class);
                Contacto cp = new Contacto();
                Usuario=(EditText)findViewById(R.id.txtNombreC);
                Email =(EditText) findViewById(R.id.txtEmail);
                Twitter = (EditText) findViewById(R.id.txtTwitter);
                Telefono = (EditText) findViewById(R.id.txtTelefono);
                FechaNac = (EditText) findViewById(R.id.txtFechaNac);
                cp.setUsuario(Usuario.getText().toString());
                cp.setEmail(Email.getText().toString());
                cp.setTwitter(Twitter.getText().toString());
                cp.setTelefono(Telefono.getText().toString());
                cp.setFecha(FechaNac.getText().toString());
                regreso = new Intent(NuevoContacto.this, MainActivity.class);
                regreso.putExtra("contacto",cp);
                setResult(RESULT_OK,regreso);
                finish();
            }
        });
    }
}
