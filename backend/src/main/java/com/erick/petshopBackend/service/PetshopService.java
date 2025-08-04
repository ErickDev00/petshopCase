package com.erick.petshopBackend.service;

import com.erick.petshopBackend.model.Petshop;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Service
public class PetshopService {

    public Petshop melhorPetshop(LocalDate data, int qtdCaesPequenos, int qtdCaesGrandes){

        Petshop meuCaninoFeliz = new Petshop ("Meu Canino Feliz", 2.0, 20.00, 40.00, 0.2, 0.2);
        Petshop vaiRex = new Petshop("Vai Rex", 1.7, 15.00, 50.00, 0.2, 0.1);
        Petshop chowChawgas = new Petshop("ChowChawgas", 0.80, 30.00, 45.00, 0, 0);


        List<Petshop> petshops = new ArrayList<>();
        petshops.add(meuCaninoFeliz);
        petshops.add(vaiRex);
        petshops.add(chowChawgas);


        return petshops.stream()
                .min(Comparator.comparingDouble((Petshop p) -> calcularPreco(data, qtdCaesPequenos, qtdCaesGrandes, p))
                        .thenComparingDouble(Petshop::getDistancia))
                .orElse(null);
    }


    private Double calcularPreco(LocalDate data, int qtdCaesPequenos, int qtdCaesGrandes, Petshop petshop){

        boolean fimDeSemana = data.getDayOfWeek() == DayOfWeek.SATURDAY ||
                data.getDayOfWeek() == DayOfWeek.SUNDAY;


        if (fimDeSemana){
            return qtdCaesPequenos * petshop.getPrecoCaoPequeno() * (1 + petshop.getAcrescimoCachorroPequeno()) +
                    qtdCaesGrandes * petshop.getPrecoCaoGrande() * (1 + petshop.getAcrescimoCachorroGrande());
        } else {
            return qtdCaesPequenos * petshop.getPrecoCaoPequeno()  +
                    qtdCaesGrandes * petshop.getPrecoCaoGrande();
        }
    }

}