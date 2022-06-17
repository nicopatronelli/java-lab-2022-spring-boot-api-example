package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor // Constructor vacío para Hibernate
@Entity
public class Pokemon {
    @Id private Integer number;
    private String name;
    private String evolution;
    private PokemonType type;

    public static Pokemon noPokemon() {
        return new Pokemon(0, "no pokemon", null, null);
    }
}
