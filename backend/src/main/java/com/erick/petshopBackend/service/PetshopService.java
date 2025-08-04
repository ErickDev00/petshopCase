package com.erick.petshopBackend.service;

import com.erick.petshopBackend.model.Petshop;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Service
public class PetshopService {

    public Petshop melhorPetshop(LocalDate data, int qtdCaesPequenos, int qtdCaesGrandes){

        Petshop meuCaninoFeliz = new Petshop ("Meu Canino Feliz", 2.0, 20.00, 40.00, 4.00, 8.00);
        Petshop vaiRex = new Petshop("Vai Rex", 1.7, 15.00, 50.00, 5.00, 5.00);
        Petshop chowChawgas = new Petshop("ChowChawgas", 0.80, 30.00, 45.00, 0, 0);


        List<Petshop> petshops = new ArrayList<>();
        petshops.add(meuCaninoFeliz);
        petshops.add(vaiRex);
        petshops.add(chowChawgas);


        for (Petshop p : petshops) {
            double total = calcularPreco(data, qtdCaesPequenos, qtdCaesGrandes, p);
            p.setPrecoTotal(total);
        }


        return petshops.stream()
                .min(Comparator.comparingDouble(Petshop::getPrecoTotal)
                        .thenComparingDouble(Petshop::getDistancia))
                .orElse(null);
    }


    private Double calcularPreco(LocalDate data, int qtdCaesPequenos, int qtdCaesGrandes, Petshop petshop){

        boolean fimDeSemana = data.getDayOfWeek() == DayOfWeek.SATURDAY ||
                data.getDayOfWeek() == DayOfWeek.SUNDAY;


        if (fimDeSemana){
            double precoPequenoComAcrescimo = petshop.getPrecoCaoPequeno() + petshop.getAcrescimoCachorroPequeno();
            double precoGrandeComAcrescimo = petshop.getPrecoCaoGrande() + petshop.getAcrescimoCachorroGrande();

            return qtdCaesPequenos * precoPequenoComAcrescimo + qtdCaesGrandes * precoGrandeComAcrescimo;
        } else {
            return qtdCaesPequenos * petshop.getPrecoCaoPequeno() +
                    qtdCaesGrandes * petshop.getPrecoCaoGrande();
        }
    }

}