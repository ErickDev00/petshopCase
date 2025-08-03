package com.erick.petshopBackend.service;

import com.erick.petshopBackend.model.Petshop;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetshopService {

    public Petshop melhorPetshop(LocalDate data, int qtdCaesPequenos, int qtdCaesGrandes){


        //instanciando PetShops
        Petshop meuCaninoFeliz = new Petshop ("Meu Canino Feliz", 2.0, 20.00, 40.00);
        Petshop vaiRex = new Petshop("Vai Rex", 1.7, 15.00, 50.00);
        Petshop chowChawgas = new Petshop("ChowChawgas", 0.80, 30.00, 45.00);

        List<Petshop> petshops = new ArrayList<>();
        petshops.add(meuCaninoFeliz);
        petshops.add(vaiRex);
        petshops.add(chowChawgas);


        //verificação fim de semana
        boolean fimDeSemana = data.getDayOfWeek() == DayOfWeek.SATURDAY ||
                data.getDayOfWeek() == DayOfWeek.SUNDAY;

        if (fimDeSemana){
            meuCaninoFeliz.setPrecoCaoPequeno(24.00);
            meuCaninoFeliz.setPrecoCaoGrande(48.00);
            vaiRex.setPrecoCaoPequeno(20.00);
            vaiRex.setPrecoCaoGrande(55.00);
        }


        //calculando preco para cada petshop
        for (Petshop p: petshops){
            double precoTotal = qtdCaesPequenos * p.getPrecoCaoPequeno() + qtdCaesGrandes * p.getPrecoCaoGrande();
            p.setPrecoTotal(precoTotal);
        }


        return comparandoPetshop(petshops);

    }


    public Petshop comparandoPetshop(List<Petshop> petshops){
        if (petshops == null || petshops.isEmpty()) return null; //tentar retornar um erro para o usuário.
        Petshop melhor = petshops.get(0);

        for (Petshop p : petshops){
            if (p.getPrecoTotal() < melhor.getPrecoTotal()){
                melhor = p;
            } else if (p.getPrecoTotal() == melhor.getPrecoTotal() && p.getDistancia() < melhor.getDistancia()){
                melhor = p;
            }
        }

        return melhor;

    }



}
