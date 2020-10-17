package com.pessoal.andre.service;

import com.pessoal.andre.repository.FilmesRepository;
import com.pessoal.andre.models.entities.FilmesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.GestaoFilmesInsertRequest;
import javassist.bytecode.DuplicateMemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class GestaoFilmesInsertService {

  private final FilmesRepository filmesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

  @Autowired
  public GestaoFilmesInsertService(FilmesRepository filmesRepository, GestaoFilmesRequestMapper requestMapper) {
    this.filmesRepository = filmesRepository;
    this.requestMapper = requestMapper;
  }

  @Transactional(rollbackFor = DataIntegrityViolationException.class)
  public void registrarFilme(GestaoFilmesInsertRequest gestaoFilmesInsertRequest) throws DuplicateMemberException {
    try {
      this.aplicaRemocao(gestaoFilmesInsertRequest);
      FilmesEntity filmesEntity = this.requestMapper.mapTO(gestaoFilmesInsertRequest);
      this.filmesRepository.save(filmesEntity);
    } catch (DataIntegrityViolationException e) {
      log.error("Issue found because this movie its duplicated!");
      throw new DuplicateMemberException("Filme em duplicidade!");
    }
  }

  private void aplicaRemocao(GestaoFilmesInsertRequest gestaoFilmesInsertRequest) {
    if (gestaoFilmesInsertRequest.getGenero().equalsIgnoreCase("TERROR")) {
      gestaoFilmesInsertRequest.setQuantidade(gestaoFilmesInsertRequest.getQuantidade() - 1);
    }
  }
}
