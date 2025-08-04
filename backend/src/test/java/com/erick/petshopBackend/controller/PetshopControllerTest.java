package com.erick.petshopBackend.controller;


import com.erick.petshopBackend.dto.PetshopDTO;
import com.erick.petshopBackend.model.Petshop;
import com.erick.petshopBackend.service.PetshopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class PetshopControllerTest {

    private PetshopController petshopController;

    @BeforeEach
    void setup() throws Exception {
        petshopController = new PetshopController();

        PetshopService serviceFake = new PetshopService() {
            @Override
            public Petshop melhorPetshop(LocalDate data, int pequenos, int grandes) {
                Petshop p = new Petshop();
                p.setNome("Vai Rex");
                return p;
            }
        };

        Field field = PetshopController.class.getDeclaredField("petshopService");
        field.setAccessible(true);
        field.set(petshopController, serviceFake);
    }

    @Test
    @DisplayName("Teste simples para requisição válida que retorna 200 e Petshop")
    void testeRequisicaoValida() {
        PetshopDTO dto = new PetshopDTO();
        dto.setData(LocalDate.now().plusDays(1));
        dto.setQtdCaesPequenos(1);
        dto.setQtdCaesGrandes(1);

        ResponseEntity<?> response = petshopController.obterMelhor(dto);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        Petshop resultado = (Petshop) response.getBody();
        assertEquals("Vai Rex", resultado.getNome());
    }
}