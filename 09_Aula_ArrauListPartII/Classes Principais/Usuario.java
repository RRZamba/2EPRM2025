package com.example.myapplication;

import java.security.PrivateKey;

public class Usuario
{
    //Entidade -  Responsavel pelos dados do usuário
    //Atributos
    private String nome;
    private String cpf;
    private String endereco;
    private String cargo;

    //Método Construtor I
    public Usuario()
    {

    }

    //Método construtor II
    public Usuario(String nome, String cpf, String endereco, String cargo)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cargo = cargo;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //Método toString()
    @Override
    public String toString()
    {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
