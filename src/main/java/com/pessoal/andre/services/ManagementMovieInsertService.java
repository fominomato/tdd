package com.pessoal.andre.services;

import com.pessoal.andre.models.entities.MovieEntity;
import com.pessoal.andre.models.mapper.ManagementMovieRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.repository.MoviesRepository;
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

  private final MoviesRepository moviesRepository;

  private final ManagementMovieRequestMapper requestMapper;

  @Transactional(rollbackFor = DataIntegrityViolationException.class)
  public void addMovie(ManagementMovieInsertRequest managementMovieInsertRequest) throws DuplicateMemberException {
    try {
      this.addRuleToInsert(managementMovieInsertRequest);
      MovieEntity movieEntity = this.requestMapper.mapTO(managementMovieInsertRequest);
      this.moviesRepository.save(movieEntity);
    } catch (DataIntegrityViolationException e) {
      log.error("Issue found because this movie its duplicated!");
      throw new DuplicateMemberException("Filme em duplicidade!");
    }
  }

  private void addRuleToInsert(ManagementMovieInsertRequest managementMovieInsertRequest) {
    if (managementMovieInsertRequest.getGenre().equalsIgnoreCase("TERROR")) {
      managementMovieInsertRequest.setQuantity(managementMovieInsertRequest.getQuantity() - 1);
    }
  }
}
