package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    double resultado = 0;
    int operador = 0; //1=+ 2=- 3=* 4=/
    int operadorTri = 0; //3=cos 2=sin 1=tan
    boolean degree = false;
    boolean newNum = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void MostrarNumeros(View view){

        TextView tv = findViewById(R.id.textView);
        Button boton = (Button)view;
        int numero = Integer.parseInt(boton.getText().toString());
        //int numInicial = Integer.parseInt(tv.getText().toString());
        if (newNum){
            tv.setText(String.valueOf(numero));
            newNum = false;
        }
        else {
            tv.setText(tv.getText().toString() + String.valueOf(numero));
        }
    }

    public void Calcular(View view) {

        TextView tv = findViewById(R.id.textView);
        double num = Double.parseDouble(tv.getText().toString());

        if (operadorTri != 0) {
            if (degree){
                num = (double) Math.toRadians(num);
            }
            if (operadorTri == 1) {
                num = Math.tan(num);
            }
            if (operadorTri == 2) {
                num = Math.sin(num);
            }
            if (operadorTri == 3) {
                num = Math.cos(num);
            }
            operadorTri = 0;
        }
        if (operador != 0) {
            if (operador == 1) {
                resultado = resultado + num;
            }
            if (operador == 2) {
                resultado = resultado - num;
            }
            if (operador == 3) {
                resultado = resultado * num;
            }
            if (operador == 4) {
                resultado = (resultado / num);
            }

        }
        if (operador == 0) {
            resultado = num;
        }
        Button boton = (Button) view;
        String id = getResources().getResourceEntryName(boton.getId());
        if (id.equals("b1")) {
            operador = 1;
            newNum = true;
            return;
        }
        if (id.equals("b2")) {
            operador = 2;
            newNum = true;
            return;
        }
        if (id.equals("b3")) {
            operador = 3;
            newNum = true;
            return;
        }
        if (id.equals("b4")) {
            operador = 4;
            newNum = true;
        } else {
            operador = 0;
            tv.setText(String.valueOf(resultado));
            newNum = true;
        }
    }

    public void Trigonometria(View view){

        TextView tv = findViewById(R.id.textView);
        Button boton = (Button)view;
        String valor = boton.getText().toString();
        int numInicial = Integer.parseInt(tv.getText().toString());
        if (degree){
            numInicial = (int) Math.toRadians(numInicial);
        }
        if (operador == 0){

            if (valor.equals("tan")){
                resultado = Math.tan(numInicial);
            }
            if (valor.equals("sin")){
                resultado = Math.sin(numInicial);
            }
            else{
                resultado = Math.cos(numInicial);
            }

            tv.setText(String.valueOf(resultado));
            newNum = true;

        }
        if (operador != 0){

            if (valor.equals("tan")){
                operadorTri = 1;
            }
            if (valor.equals("sin")){
                operadorTri = 2;
            }
            else{
                operadorTri = 3;
            }
        }

    }

    public void CambiarUnidad(View view){

        Button boton = (Button)view;
        if (degree == true){
            degree = false;
            boton.setText("rad");
        }
        else {
            degree = true;
            boton.setText("deg");
        }
    }
}