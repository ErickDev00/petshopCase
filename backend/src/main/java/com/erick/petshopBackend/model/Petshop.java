package com.erick.petshopBackend.model;

import java.time.LocalDate;

public class Petshop {

    String nome;
    LocalDate data;
    double distancia;
    double precoCaoPequeno;
    double precoCaoGrande;
    double precoTotal;
    int qtdCaesPequenos;
    int qtdCaesGrandes;


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




}
