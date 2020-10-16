package com.ford.cognizant.tdd.service;

import com.ford.cognizant.tdd.models.entities.FilmesEntity;
import com.ford.cognizant.tdd.models.mapper.GestaoFilmesRequestMapper;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByRequest;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByResponse;
import com.ford.cognizant.tdd.repository.FilmesRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GestaoFilmesSearchService {

  private final FilmesRepository filmesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

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
