package com.erick.petshopBackend.model;

public class Petshop {

    String nome;
    private double distancia;
    private double precoCaoPequeno;
    private double precoCaoGrande;
    private double acrescimoCachorroPequeno;
    private double acrescimoCachorroGrande;



    //construtores
    public Petshop(){
    }


    public Petshop(String nome,
                   double distancia,
                   double precoCaoPequeno,
                   double precoCaoGrande,
                   double acrescimoCachorroPequeno,
                   double acrescimoCachorroGrande){
        this.nome = nome;
        this.distancia = distancia;
        this.precoCaoPequeno = precoCaoPequeno;
        this.precoCaoGrande = precoCaoGrande;
        this.acrescimoCachorroPequeno = acrescimoCachorroPequeno;
        this.acrescimoCachorroGrande = acrescimoCachorroGrande;
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

    public double getAcrescimoCachorroPequeno() {
        return acrescimoCachorroPequeno;
    }

    public void setAcrescimoCachorroPequeno(double acrescimoCachorroPequeno) {
        this.acrescimoCachorroPequeno = acrescimoCachorroPequeno;
    }

    public double getAcrescimoCachorroGrande() {
        return acrescimoCachorroGrande;
    }

    public void setAcrescimoCachorroGrande(double acrescimoCachorroGrande) {
        this.acrescimoCachorroGrande = acrescimoCachorroGrande;
    }


}