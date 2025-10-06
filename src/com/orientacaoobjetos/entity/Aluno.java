package com.orientacaoobjetos.entity;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluno {

    private String nome;
    private String dataNascimento;
    private String serie;
    private int idade;
    private int registroDoAluno;
    private static int registroGeral = 1;
    private double[] notas;

    public Aluno(String nome, String dataNascimento, String serie) throws Exception {

        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.serie = serie;
        this.idade = calcularIdade(dataNascimento);
        registroDoAluno = registroGeral;
        notas = new double[4];
        registroGeral += 1;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() throws Exception{
        atualizarIdade();
        return idade;
    }

    public String getSerie() {
        return serie;
    }

    public int getRegistroDoAluno() {
        return registroDoAluno;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public double[] getNotas() {
        return notas;
    }

    public void cadastrarNota(int index, double nota){
        this.notas[index] = nota;
    }

    public void atualizarIdade() throws Exception {
        idade = calcularIdade(dataNascimento);
    }

    public double calcularMedia(){

        double media = 0;

        for(double n : notas){
            media += n;
        }
        return media/notas.length;
    }


    @Override
    public String toString() {
        return String.format("| ID do Aluno: %d\n| Nome: %s\n| Idade: %d\n| Serie: %s",
                registroDoAluno, nome, idade, serie);
    }

    private int calcularIdade(String dataNascimento) throws Exception {

        try{
            dataNascimento = dataNascimento.replace("/", "-");
            LocalDate birthDate = LocalDate.parse(dataNascimento, DateTimeFormatter.ISO_LOCAL_DATE);
            return Period.between(birthDate, LocalDate.now()).getYears();
        } catch (Exception e){
            throw new Exception("Data de nascimento inserida incorretamente");
        }
    }
}
