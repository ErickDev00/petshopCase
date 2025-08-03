package com.erick.petshopBackend.controller;

import com.erick.petshopBackend.dto.PetshopDTO;
import com.erick.petshopBackend.model.Petshop;
import com.erick.petshopBackend.service.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/petshop")
@CrossOrigin(origins = "http://localhost:5173")
public class PetshopController {

    @Autowired
    private PetshopService petshopService;


    @PostMapping("/melhor-opcao")
    public ResponseEntity<?> obterMelhor(@RequestBody PetshopDTO dto) {

        Petshop melhor = petshopService.melhorPetshop(dto.getData(), dto.getQtdCaesPequenos(), dto.getQtdCaesGrandes());

        return ResponseEntity.ok(melhor);
    }


}
