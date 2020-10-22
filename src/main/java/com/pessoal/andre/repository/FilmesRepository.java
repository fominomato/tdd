package com.pessoal.andre.repository;

import com.pessoal.andre.models.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<MoviesEntity, Long> {

}
