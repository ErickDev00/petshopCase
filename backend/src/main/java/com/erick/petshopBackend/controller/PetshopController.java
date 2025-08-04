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
@CrossOrigin(origins = "*")
public class PetshopController {

    @Autowired
    private PetshopService petshopService;


    @PostMapping("/melhor-opcao")
    public ResponseEntity<?> obterMelhor(@RequestBody PetshopDTO dto) {

        //verificações para evitar erros
        if (dto.getData() == null || dto.getData().isBefore(LocalDate.now())) {
            return ResponseEntity.badRequest().body("Data inválida. Deve ser hoje ou futura.");
        }

        if (dto.getQtdCaesPequenos() < 0 || dto.getQtdCaesGrandes() < 0) {
            return ResponseEntity.badRequest().body("Quantidade de cães não pode ser negativa.");
        }

        if (dto.getQtdCaesPequenos() + dto.getQtdCaesGrandes() < 1) {
            return ResponseEntity.badRequest().body("Informe pelo menos um cão.");
        }


        Petshop melhor = petshopService.melhorPetshop(dto.getData(), dto.getQtdCaesPequenos(), dto.getQtdCaesGrandes());

        return ResponseEntity.ok(melhor);
    }


}
