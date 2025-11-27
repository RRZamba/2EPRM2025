package com.example.bdexterno;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper
{
    //Atributos
    String TAG = BancoDeDados.class.getSimpleName();
    //Numero da classe
    int flag;
    //Nome do DB
    static String DB_Name = "dbAluno";
    //Context para 'pegar' a programacao da activity
    Context meuContexto;
    //Arquivo de saida
    String saidaFile = "";
    //Caminho onde ficara salvo o DB
    String DB_Path;
    //Classe para executar as operacoes do DB
    SQLiteDatabase db;

    //Metodo Construtor
    public BancoDeDados(Context context)
    {
        super(context,DB_Name,null,1);

        //Inserindo o contexto no parametro
        this.meuContexto = context;

        //Recuperando o caminho do DB no cel....
        ContextWrapper cw = new ContextWrapper(this.meuContexto);
        DB_Path = cw.getFilesDir().getAbsolutePath()+"/databases/";

        //MEns de Log
        Log.e(TAG,"Banco de Dados: "+DB_Path);

        // Montar os caminhos completos do DB
        File file = new File(DB_Path);

        //MEns de Log
        Log.e(TAG,"Bando de Dados:"+file.exists());

        //Se nao existir ele abre o caminho
        if(!file.exists())
        {
            file.mkdir();
        }
    }


    //Copiando o Banco de Dados
    public void copiandoDB()
    {
        //Criando um Buffer para passar o DB dentro do CEL....
        byte[] buffer = new byte[1024];
        OutputStream minhaSaida =null;
        InputStream minhaEntrada = null;
        int tamanho;

        try
        {
            //Pegando o bando de dados da pasta ASSETS
            minhaEntrada = meuContexto.getAssets().open(DB_Name);

            //Transferindo do ASSETS para o CEL...
            minhaSaida = new FileOutputStream(DB_Path+DB_Name);

            //Percorrer byte por byte salvando o DB
            while((tamanho = minhaEntrada.read(buffer)) > 0)
            {
                minhaSaida.write(buffer,0,tamanho);
            }

            // Fechar os arquivos
            minhaEntrada.close();
            minhaSaida.close();


            //Chegou ate aqui.... LOG que deu certo!!!!
            Log.e(TAG,"Banco de dados foi copiado!!!!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }//

    //Verificando se DB ja existe
    public boolean checandoDB()
    {
        db = null;

        try
        {
            //Forcando a abertura do Banco de Dados
            SQLiteDatabase.openDatabase(saidaFile,null,
                                    SQLiteDatabase.OPEN_READWRITE);
        }
        catch(SQLiteException erro)
        {
            copiandoDB();
        }

        if(db != null)
        {
            db.close();
        }

        return db != null ? true : false;
    }

    //Abrindo o DB
    public void openDB()
    {
        //Verificar se DB existe
        boolean existeDB =  checandoDB();

        if(!existeDB)
        {
            this.getReadableDatabase();
            copiandoDB();
        }
    }//


   





    //Metodos herdados da classe SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {

    }//

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//


}

