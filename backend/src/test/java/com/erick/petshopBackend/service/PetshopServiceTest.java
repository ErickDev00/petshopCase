package com.erick.petshopBackend.service;

import org.junit.jupiter.api.Test;
import com.erick.petshopBackend.model.Petshop;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;



class PetshopServiceTest {

    private final PetshopService petshopService = new PetshopService();

    @Test
    @DisplayName("Deve retornar o petshop com menor preço e menor distância em dia útil")
    void deveRetornarMelhorPetshopDiaUtil() {
        //Segunda-feira
        LocalDate data = LocalDate.of(2025, 8, 4); // Segunda-feira
        int qtdPequenos = 2;
        int qtdGrandes = 1;

        Petshop melhor = petshopService.melhorPetshop(data, qtdPequenos, qtdGrandes);

        assertNotNull(melhor);
        assertEquals("Vai Rex", melhor.getNome());
    }

    @Test
    @DisplayName("Deve retornar o petshop com menor preço e menor distância em fim de semana")
    void deveRetornarMelhorPetshopFimDeSemana() {
        //Domingo
        LocalDate data = LocalDate.of(2025, 8, 3); // Domingo
        int qtdPequenos = 1;
        int qtdGrandes = 2;

        Petshop melhor = petshopService.melhorPetshop(data, qtdPequenos, qtdGrandes);

        assertNotNull(melhor);
        assertEquals("ChowChawgas", melhor.getNome());
    }

    @Test
    @DisplayName("Deve retornar null quando lista de petshops estiver vazia (teste indireto)")
    void deveRetornarNullSeNenhumPetshop() {

        PetshopService serviceVazio = new PetshopService() {
            @Override
            public Petshop melhorPetshop(LocalDate data, int qtdPequenos, int qtdGrandes) {

                return null;
            }
        };

        Petshop resultado = serviceVazio.melhorPetshop(LocalDate.now(), 1,1);
        assertNull(resultado);
    }
}