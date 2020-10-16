package com.ford.cognizant.tdd.service;

import com.ford.cognizant.tdd.models.entities.FilmesEntity;
import com.ford.cognizant.tdd.models.mapper.GestaoFilmesRequestMapper;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesInsertRequest;
import com.ford.cognizant.tdd.repository.FilmesRepository;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class GestaoFilmesInsertService {

  private final FilmesRepository filmesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

  @Transactional(rollbackFor = DataIntegrityViolationException.class)
  public void registrarFilme(GestaoFilmesInsertRequest gestaoFilmesInsertRequest) throws DuplicateMemberException {
    try {
      if (gestaoFilmesInsertRequest.getGenero().equalsIgnoreCase("TERROR")) {
        gestaoFilmesInsertRequest.setQuantidade(gestaoFilmesInsertRequest.getQuantidade() - 1);
      }
      FilmesEntity filmesEntity = this.requestMapper.mapTO(gestaoFilmesInsertRequest);
      this.filmesRepository.save(filmesEntity);
    } catch (DataIntegrityViolationException e) {
      log.error("Issue found because this movie its duplicated!");
      throw new DuplicateMemberException("Filme em duplicidade!");
    }
  }
}
