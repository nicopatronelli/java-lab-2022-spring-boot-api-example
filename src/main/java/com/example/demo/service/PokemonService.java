package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.repository.PokemonRepository;
import com.example.demo.domain.Pokemon;

import static java.util.Objects.nonNull;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemons::add);
        return pokemons;
    }

    public Pokemon getPokemonByNumber(Integer number) {
        return pokemonRepository.findById(number).orElse(Pokemon.noPokemon());
    }

    public Pokemon getPokemonByName(String name){
        return pokemonRepository.findByName(name);
    }

    public List<Pokemon> getPokemonsByEvolution(String evolution){
        return pokemonRepository.findByEvolution(evolution);
    }

    public void addPokemon(Pokemon pokemon){
        pokemonRepository.save(pokemon);
    }

    public void updatePokemon(Pokemon pokemon) {
        final Pokemon pokemonToUpdate = pokemonRepository.findById(pokemon.getNumber()).orElse(null);
        final Pokemon pokemonUpdated = buildPokemonUpdated(pokemonToUpdate, pokemon);
        pokemonRepository.save(pokemonUpdated);
    }

    private Pokemon buildPokemonUpdated(Pokemon pokemonToUpdate, Pokemon pokemonWithChanges) {
        return new Pokemon(
                nonNull(pokemonWithChanges.getNumber()) ? pokemonWithChanges.getNumber() : pokemonToUpdate.getNumber(),
                nonNull(pokemonWithChanges.getName()) ? pokemonWithChanges.getName() : pokemonToUpdate.getName(),
                nonNull(pokemonWithChanges.getEvolution()) ?
                        pokemonWithChanges.getEvolution() :
                        pokemonToUpdate.getEvolution(),
                nonNull(pokemonWithChanges.getType()) ? pokemonWithChanges.getType() : pokemonToUpdate.getType()
        );
    }

    public void removePokemon(Integer number) {
        pokemonRepository.deleteById(number);
    }
}
