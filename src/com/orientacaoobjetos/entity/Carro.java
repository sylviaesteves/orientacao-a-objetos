package com.orientacaoobjetos.entity;

public class Carro {

    String nome;
    double preco;

    public Carro(String nome, double preco){

        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("-------------------------\nNome: %s\n" +
                "Preço: R$%.2f\n-------------------------", nome, preco);
    }
}
