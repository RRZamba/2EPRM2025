package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Atributos
    EditText txtNome,txtId,txtCurso;
    Button btnSalvar,btnAtualizar,btnSelecionar,btnDeletar,btnLista;

    SQLiteDatabase bcoDadosShow;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnDeletar = (Button) findViewById(R.id.btnDeletar);
        btnAtualizar = (Button) findViewById(R.id.btnAtualizar);
        btnSelecionar = (Button) findViewById(R.id.btnSelecionar);
        btnLista = (Button) findViewById(R.id.btnLista);

        //Chamando o metodo
        criaDB();

        //Botão Selecionar
        btnSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelecionarUnico();
            }
        });

        //Botão Gravar
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Gravar();
            }
        });

        //Botão Lista
        btnLista.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it = new Intent(MainActivity.this,
                                        ListaActivity.class);
                startActivity(it);
            }
        });
    } //onCreate

    //Método para criar/abrir o banco de dados
    public void criaDB()
    {
        // String para montar a query
        String sql;

        try
        {
            //Criando a tabela, caso a mesma não exista
            sql = "CREATE TABLE IF NOT EXISTS Aluno(" +
                  "Matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                  "Nome TEXT," +
                  "Curso TEXT)";

            //Criando/Abrindo o banco de dados
            bcoDadosShow = openOrCreateDatabase("ETEC",
                                                MODE_PRIVATE,
                                                null);

            // Executando a query
            bcoDadosShow.execSQL(sql);

            // Mens. de sucesso!!!
            Toast.makeText(MainActivity.this,
                           "Sistema carregado com sucesso!!!",
                           Toast.LENGTH_LONG).show();

        }
        catch(Exception erro)
        {
            //Mensagem de erro
            Toast.makeText(MainActivity.this,
                    "Erro!!!: " + erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }




    }

    //Método Gravar
    public void Gravar()
    {
        //EditText
        txtCurso = (EditText) findViewById(R.id.txtCurso);
        txtNome = (EditText) findViewById(R.id.txtNome);

        //String Query
        String sql;

        try
        {
            //Query de Insert
            sql = "INSERT INTO Aluno(Nome,Curso) VALUES" +
                  "('"+txtNome.getText().toString()+"'," +
                  "'"+txtCurso.getText().toString()+"')";

            //Executando a query
            bcoDadosShow.execSQL(sql);

            Toast.makeText(MainActivity.this,
                    "Aluno  inserido com sucesso!!!",
                    Toast.LENGTH_LONG).show();

            //Limpando os campos
            txtNome.setText("");
            txtCurso.setText("");

        }
        catch(Exception erro)
        {
            //Mensagem de erro
            Toast.makeText(MainActivity.this,
                    "Erro!!!: " + erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

    }


    //Método SelecionarUnico
    public void SelecionarUnico()
    {
        // EditText ID
        txtId = (EditText) findViewById(R.id.txtId);

        // Query
        String sql = "SELECT * FROM Aluno WHERE Matricula =" +
                     txtId.getText().toString();

        try
        {
           //Criando um cursor para armazenar os dados
            Cursor objCursor;

            //Executando a query e salvando os resultados
            objCursor = bcoDadosShow.rawQuery(sql,null);

            Aluno objAluno = new Aluno();
            ArrayList<Aluno> listaLog = new ArrayList<Aluno>();

            // 7)percorrendo o cursor
            while(objCursor.moveToNext())
            {
                objAluno.setMatricula(objCursor.getInt(0));
                objAluno.setNome(objCursor.getString(1));
                objAluno.setCurso(objCursor.getString(2));

                //Salvando dentro da lista
                listaLog.add(objAluno);
            }

            // 8) Mostrar os valores
            Toast.makeText(this,
                    "Nome:"+listaLog.get(0).getNome()+
                            " Curso:"+listaLog.get(0).getCurso(),
                    Toast.LENGTH_LONG).show();

        }
        catch (Exception erro)
        {
            //Mensagem de erro
            Toast.makeText(this,
                    "Erro ao Selecionar Aluno!"+
                            erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }



}