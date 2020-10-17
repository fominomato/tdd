package com.pessoal.andre.repository;

import com.pessoal.andre.models.entities.FilmesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<FilmesEntity, Long> {

}
