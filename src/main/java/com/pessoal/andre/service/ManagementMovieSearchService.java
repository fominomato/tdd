package com.pessoal.andre.service;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.repository.FilmesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ManagementMovieSearchService {

  private final FilmesRepository filmesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

  @Autowired
  public ManagementMovieSearchService(FilmesRepository filmesRepository, GestaoFilmesRequestMapper requestMapper) {
    this.filmesRepository = filmesRepository;
    this.requestMapper = requestMapper;
  }

  public List<ManagementMovieFindByResponse> searchMovies(ManagementMovieFindByRequest findByRequest) {
    List<MoviesEntity> entityList = this.filmesRepository.findAll().stream()
      .filter(item ->
          (findByRequest.getGenre() != null && findByRequest.getGenre().equalsIgnoreCase(item.getGenre())) ||
          (findByRequest.getName() != null && findByRequest.getName().equalsIgnoreCase(item.getName()))
      )
      .collect(Collectors.toList());
      return entityList.stream()
          .map(this.requestMapper::mapTO)
          .collect(Collectors.toList());
  }
}
