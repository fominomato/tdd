package com.pessoal.andre.service;

import com.pessoal.andre.repository.FilmesRepository;
import com.pessoal.andre.models.entities.FilmesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.GestaoFilmesFindByRequest;
import com.pessoal.andre.models.representation.GestaoFilmesFindByResponse;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GestaoFilmesSearchService {

  private final FilmesRepository filmesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

  @Autowired
  public GestaoFilmesSearchService(FilmesRepository filmesRepository, GestaoFilmesRequestMapper requestMapper) {
    this.filmesRepository = filmesRepository;
    this.requestMapper = requestMapper;
  }

  public List<GestaoFilmesFindByResponse> pesquisaFilmes(GestaoFilmesFindByRequest findByRequest) {
    List<FilmesEntity> entityList = this.filmesRepository.findAll().stream()
      .filter(item ->
          (findByRequest.getGenero() != null && findByRequest.getGenero().equalsIgnoreCase(item.getGenero())) ||
          (findByRequest.getNome() != null && findByRequest.getNome().equalsIgnoreCase(item.getNome()))
      )
      .collect(Collectors.toList());
      return entityList.stream()
          .map(this.requestMapper::mapTO)
          .collect(Collectors.toList());
  }
}
