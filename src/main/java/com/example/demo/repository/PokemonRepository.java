package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.domain.Pokemon;
import com.example.demo.domain.PokemonType;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
    Pokemon findByName(String name);
    List<Pokemon> findByEvolution(String evolution);
//    List<Pokemon> findByLevelAndType(int level, PokemonType type);
//    List<Pokemon> findByLevelOrType(int level, PokemonType type);
//    List<Pokemon> findByTypeIn(PokemonType... types);
//    Pokemon findByNameIgnoreCase(String name);
//    List<Pokemon> findByNameLike(String name);
//    List<Pokemon> findByNameLikeOrderByNameAsc(String name);
//    List<Pokemon> findByNameStartingWith(String name);
}