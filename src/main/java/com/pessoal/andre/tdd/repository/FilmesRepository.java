package com.ford.cognizant.tdd.repository;

import com.ford.cognizant.tdd.models.entities.FilmesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<FilmesEntity, Long> {

}
