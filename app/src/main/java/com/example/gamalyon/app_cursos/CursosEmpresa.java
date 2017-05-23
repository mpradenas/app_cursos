package com.example.gamalyon.app_cursos;

import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Gamalyon on 20/05/2017.
 */

public class CursosEmpresa {

    public static String nombre;
    public static String rut;
    public static int cantidadAlumnos;
    public static int curso;
    public static String[] cursosPrecios;
    public static Boolean clteFrecuente;
    public static double descuentos;

    public static double CalculaDesctos(int cantidadAlumnos, double valorCurso, boolean clteFrecuente, RadioGroup rg)
    {
        double descto=0;
       //calculo la cantidad de dsctos segun el número de alumnos

        if(cantidadAlumnos>4 && cantidadAlumnos<11)
       {
           descto=(valorCurso*cantidadAlumnos)*0.10;
       }
       else if(cantidadAlumnos>10 && cantidadAlumnos<16)
       {
           descto=(valorCurso*cantidadAlumnos)*0.20;
       }
       else if(cantidadAlumnos>15 && cantidadAlumnos<21)
       {
           descto=(valorCurso*cantidadAlumnos)*0.25;
       }
       else
       {
           descto=0;
       }
        valorCurso=(valorCurso*cantidadAlumnos);
        //si es cliente frecuente se crea un descuento de 5%
        double desctoCltFrcte= clteFrecuente==true? valorCurso*0.05 : 0;
        int val=rg.getCheckedRadioButtonId();
        int val2=R.id.o1;
        //si el curso se imparte en las aulas de la empresa de los cursos se agregan un valor extra de 5000 pesos, si no, no.
        valorCurso=rg.getCheckedRadioButtonId()==R.id.o1 ? valorCurso-descto-desctoCltFrcte+(5000*cantidadAlumnos) : valorCurso-descto-desctoCltFrcte;
        return valorCurso;
    }

}


