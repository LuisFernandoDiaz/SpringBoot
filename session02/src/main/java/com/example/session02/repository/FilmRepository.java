package com.example.session02.repository;

import com.example.session02.entity.Film;
import jakarta.persistence.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

    @Cacheable(value = "films")
    Iterable<Film> findAll();

    @CacheEvict(value = "films", allEntries = true)
    Film save(Film film);

}
