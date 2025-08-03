package com.erick.petshopBackend.controller;

import com.erick.petshopBackend.model.Petshop;
import com.erick.petshopBackend.service.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/petshop")
public class PetshopController {

    @Autowired
    private PetshopService petshopService;


    @PostMapping("/melhor-opcao")
    public Petshop obterMelhor(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam int qtdCaesPequenos,
            @RequestParam int qtdCaesGrandes) {

        return petshopService.melhorPetshop(data, qtdCaesPequenos, qtdCaesGrandes);
    }


}
