package com.example.myapplication;

public class Aluno
{
    // 1) Atributos
    private int matricula;
    private String nome;
    private String curso;

    //Método Construtor I
    public Aluno(){}

    //Método Construtor II
    public Aluno(int matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    //Getters & Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    //ToString
    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
