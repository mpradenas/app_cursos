package com.example.gamalyon.app_cursos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;



public class activity2 extends AppCompatActivity {

    private Spinner spinner;
    private EditText edt1,edt2,edt3;
    private CheckBox cltFcte;
    private Adapter adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        edt1=(EditText) findViewById(R.id.editText);
        edt2=(EditText) findViewById(R.id.editText2);
        edt3=(EditText) findViewById(R.id.editText5);
        cltFcte=(CheckBox) findViewById(R.id.checkBox);
        String[]cursoss=new String[]{"Selecciona","Curso 1 $350.000","Curso 2 $450.000","Curso 3 $300.000","Curso 4 $500.000","Curso 5 $450.000"};
        adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,cursoss);
        spinner=(Spinner) findViewById(R.id.spinner);
        spinner.setAdapter((SpinnerAdapter) adaptador);

    }

    public void siguiente(View view)
    {
        //verifico si los campos están vacíos o no seleccionados
        if(!TextUtils.isEmpty(edt1.getText().toString()) && !TextUtils.isEmpty(edt2.getText().toString()) && !TextUtils.isEmpty(edt3.getText().toString()) && spinner.getSelectedItemPosition()>0)
        {
            if(Integer.parseInt(edt3.getText().toString())>1 && Integer.parseInt(edt3.getText().toString())<21) {
                //Aquí asignaré los valores en variables de una clase statica que se usará en las distintas activities
                CursosEmpresa.nombre = edt1.getText().toString();
                CursosEmpresa.rut = edt2.getText().toString();
                CursosEmpresa.cantidadAlumnos = Integer.parseInt(edt3.getText().toString());
                CursosEmpresa.clteFrecuente=cltFcte.isChecked()==true? true:false;
                //invoco el procedimiento que setea el precio del curso y el nombre del curso
                setPrecioCurso(spinner.getSelectedItemPosition());
                Intent intent = new Intent(this, activity3.class);
                startActivity(intent);

            }
            else
            {
                Toast.makeText(this,"La cantidad de alumnos debe ser como mínimo de 2 y máximo 20",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"No dejes campos de texto vacíos, ni olvides seleccionar el curso esperado", Toast.LENGTH_SHORT).show();
        }
    }

    private void setPrecioCurso(int posicion)
    {
        String curso=spinner.getSelectedItem().toString();
        String precio="";
        switch (posicion)
        {
            case 1:
                precio ="350000";
                break;
            case 2:
                precio ="450000";
                break;
            case 3:
                precio ="300000";
                break;
            case 4:
                precio ="500000";
                break;
            case 5:
                precio ="450000";
                break;
        }
        CursosEmpresa.cursosPrecios = new String[]{curso,precio};
    }


}
