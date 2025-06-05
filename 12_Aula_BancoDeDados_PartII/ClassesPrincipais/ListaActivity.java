package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity
{

    //1) Atributos
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //2) Iniciando
        lista = (ListView) findViewById(R.id.lista);

        //3) ArrayList<>
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

        //4) Iniciando o DB
        SQLiteDatabase bcoDados =
                    openOrCreateDatabase("ETEC",MODE_PRIVATE,
                                        null);

        // 4) Cursor, para receber os dados
        Cursor resultado = bcoDados.rawQuery(
                     "SELECT * FROM Aluno",null);


        // 5) Percorrendo o cursor, linha a linha
        while(resultado.moveToNext())
        {
            //Preenchendo o aluno
            Aluno aluno = new Aluno();
            aluno.setMatricula(resultado.getInt(0));
            aluno.setNome(resultado.getString(1));
            aluno.setCurso(resultado.getString(2));

            //Adicionando o aluno na lista
            listaAlunos.add(aluno);
        }

        //6) Adaptando o ArrayList<>
        ArrayAdapter<Aluno> adaptador = new
                ArrayAdapter<Aluno>(ListaActivity.this,
                          android.R.layout.simple_list_item_1,
                            listaAlunos);

        //7) inserindo a lista adaptada no ListView
        lista.setAdapter(adaptador);
    }
}