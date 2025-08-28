package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    //1) Atributos
    EditText txtProduto, txtValor;
    Switch swDesconto;
    SeekBar seekBar;
    Button btnResultado;

    TextView lblValorSeekBar;

    //Posição seekbar
    double valorSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) Linkar os elementos
        txtProduto = (EditText) findViewById(R.id.txtProduto);
        txtValor = (EditText) findViewById(R.id.txtValor);
        swDesconto = (Switch) findViewById(R.id.swDesconto);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnResultado = (Button) findViewById(R.id.btnResultado);
        lblValorSeekBar = (TextView) findViewById(R.id.lblValorSeekBar);



        //Desativar a Seekbar
        seekBar.setActivated(false);

        //Limitando valor
        seekBar.setMax(45);

        //Evento switch
        swDesconto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                seekBar.setActivated(true);
            }
        });




        // 3) SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b)
            {
                valorSeekBar = position;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                lblValorSeekBar.setText(valorSeekBar + " %");
            }
        }); //

        //4) Button
        btnResultado.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String produto = txtProduto.getText().toString();
                double valorProduto = Double.parseDouble(
                                   txtValor.getText().toString());

                //Calculo
                double valorFinal = valorProduto - (valorProduto * (valorSeekBar/100));

                //Mensagem
                String mensagem = "Produto: " + produto +
                                  "\n Valor Inicial: " + valorProduto +
                                  "\n Novo Valor: " + valorFinal;

                //Toast
                Toast.makeText(MainActivity.this,
                              mensagem, Toast.LENGTH_LONG).show();

            }
        });






    }
}