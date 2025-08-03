package com.erick.petshopBackend.model;

import java.time.LocalDate;

public class Petshop {

    String nome;
    double distancia;
    double precoCaoPequeno;
    double precoCaoGrande;
    double precoTotal;


    //construtores
    public Petshop(){
    }

    /*public Petshop(String nome, double distancia, double precoCaoPequeno, double precoCaoGrande,
                    LocalDate data, int qtdCaesPequenos, int qtdCaesGrandes){
        this.nome = nome;
        this.distancia = distancia;
        this.precoCaoPequeno = precoCaoPequeno;
        this.precoCaoGrande = precoCaoGrande;
        this.data = data;
        this.qtdCaesPequenos = qtdCaesPequenos;
        this.qtdCaesGrandes = qtdCaesGrandes;
    } */

    public Petshop(String nome, double distancia, double precoCaoPequeno, double precoCaoGrande){
        this.nome = nome;
        this.distancia = distancia;
        this.precoCaoPequeno = precoCaoPequeno;
        this.precoCaoGrande = precoCaoGrande;
    }


    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPrecoCaoPequeno() {
        return precoCaoPequeno;
    }

    public void setPrecoCaoPequeno(double precoCaoPequeno) {
        this.precoCaoPequeno = precoCaoPequeno;
    }

    public double getPrecoCaoGrande() {
        return precoCaoGrande;
    }

    public void setPrecoCaoGrande(double precoCaoGrande) {
        this.precoCaoGrande = precoCaoGrande;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }


}
