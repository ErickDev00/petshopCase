package com.erick.petshopBackend.dto;

import java.time.LocalDate;

public class PetshopDTO {
    private LocalDate data;
    private int qtdCaesPequenos;
    private int qtdCaesGrandes;


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQtdCaesPequenos() {
        return qtdCaesPequenos;
    }

    public void setQtdCaesPequenos(int qtdCaesPequenos) {
        this.qtdCaesPequenos = qtdCaesPequenos;
    }

    public int getQtdCaesGrandes() {
        return qtdCaesGrandes;
    }

    public void setQtdCaesGrandes(int qtdCaesGrandes) {
        this.qtdCaesGrandes = qtdCaesGrandes;
    }










}
