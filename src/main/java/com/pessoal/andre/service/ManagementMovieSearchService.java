package com.pessoal.andre.service;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagementMovieSearchService {

  private final MoviesRepository moviesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

  public List<ManagementMovieFindByResponse> searchMovies(ManagementMovieFindByRequest findByRequest) {
    List<MoviesEntity> entityList = this.moviesRepository.findAll().stream()
      .filter(item ->
          (findByRequest.getGenre() != null && findByRequest.getGenre().equalsIgnoreCase(item.getGenre())) ||
          (findByRequest.getName() != null && findByRequest.getName().equalsIgnoreCase(item.getName()))
      )
      .collect(Collectors.toList());
    log.info("A pesquisa retornou " + this.moviesRepository.findAll().size() + " registros!");
    return entityList.stream()
        .map(this.requestMapper::mapTO)
        .collect(Collectors.toList());
  }
}
