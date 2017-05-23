package com.example.gamalyon.app_cursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class activity3 extends AppCompatActivity {

    private RadioButton rdB1;
    RadioGroup rg;
    TextView tv8,tv9,tv10,tv11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        rg=(RadioGroup) findViewById(R.id.rgroup);
        tv8=(TextView) findViewById(R.id.textView8);
        tv9=(TextView) findViewById(R.id.textView9);
        tv10=(TextView) findViewById(R.id.textView10);
        tv11=(TextView) findViewById(R.id.textView11);
    }

    public void Calcula(View view)
    {
        double precioXalumno;
        String textoClteFrecuente="";

        double valorTotal=CursosEmpresa.CalculaDesctos(CursosEmpresa.cantidadAlumnos,Double.parseDouble(CursosEmpresa.cursosPrecios[1]),CursosEmpresa.clteFrecuente,rg);
        Toast.makeText(this, "funciona 2", Toast.LENGTH_SHORT).show();

        tv8.setText("Nombre curso: "+CursosEmpresa.cursosPrecios[0]+" valor: $"+CursosEmpresa.cursosPrecios[1]);
        textoClteFrecuente=CursosEmpresa.clteFrecuente==true? "Cliente frecuente con 5% descuento ": "Cliente nuevo";
        tv9.setText(textoClteFrecuente);
        tv10.setText("Valor total final por cada alumno:"+String.valueOf((valorTotal/CursosEmpresa.cantidadAlumnos)));
        tv11.setText("Valor total final general:"+String.valueOf(valorTotal));

    }
}
