package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.service.PokemonService;
import com.example.demo.domain.Pokemon;

@RestController
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons") // @RequestMapping("/pokemons")
    public List<Pokemon> getAllPokemons(){
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/pokemons/{number}")
    public Pokemon getPokemon(@PathVariable Integer number) {
        return pokemonService.getPokemonByNumber(number);
    }

    @GetMapping("/pokemons/name/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return pokemonService.getPokemonByName(name);
    }

    @GetMapping("/pokemons/evolution/{evolution}")
    public List<Pokemon> getPokemonsByEvolution(@PathVariable String evolution) {
        return pokemonService.getPokemonsByEvolution(evolution);
    }

    @PutMapping("/pokemons")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPokemon(@RequestBody Pokemon pokemon){
        pokemonService.addPokemon(pokemon);
    }

    @PatchMapping("/pokemons")
    public void updatePokemon(@RequestBody Pokemon pokemon){
        pokemonService.updatePokemon(pokemon);
    }

    @DeleteMapping("/pokemons/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePokemon(@PathVariable Integer number){
        pokemonService.removePokemon(number);
    }
}
