package com.pessoal.andre.service;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.repository.FilmesRepository;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagementMovieInsertService {

  private final FilmesRepository filmesRepository;

  private final GestaoFilmesRequestMapper requestMapper;

  @Transactional(rollbackFor = DataIntegrityViolationException.class)
  public void registrarFilme(ManagementMovieInsertRequest managementMovieInsertRequest) throws DuplicateMemberException {
    try {
      this.aplicaRemocao(managementMovieInsertRequest);
      MoviesEntity moviesEntity = this.requestMapper.mapTO(managementMovieInsertRequest);
      this.filmesRepository.save(moviesEntity);
    } catch (DataIntegrityViolationException e) {
      log.error("Issue found because this movie its duplicated!");
      throw new DuplicateMemberException("Filme em duplicidade!");
    }
  }

  private void aplicaRemocao(ManagementMovieInsertRequest managementMovieInsertRequest) {
    if (managementMovieInsertRequest.getGenero().equalsIgnoreCase("TERROR")) {
      managementMovieInsertRequest.setQuantidade(managementMovieInsertRequest.getQuantidade() - 1);
    }
  }
}
