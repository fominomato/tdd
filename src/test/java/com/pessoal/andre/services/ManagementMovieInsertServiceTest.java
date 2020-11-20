package com.pessoal.andre.services;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.mock.representation.ManagementMovieInsertRequestMock;
import com.pessoal.andre.models.entities.MovieEntity;
import com.pessoal.andre.models.mapper.ManagementMovieRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.repository.MoviesRepository;
import javassist.bytecode.DuplicateMemberException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ManagementMovieInsertServiceTest {

  @InjectMocks
  private ManagementMovieInsertService service;

  @Mock
  private MoviesRepository repository;

  @Mock
  private ManagementMovieRequestMapper requestMapper;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  private MoviesMock moviesMock = new MoviesMock();

  private ManagementMovieInsertRequestMock requestMock = new ManagementMovieInsertRequestMock();

  @Test
  public void addMovie() throws DuplicateMemberException {
    MovieEntity movieEntity = this.moviesMock.getMoviesEntity();
    when(this.repository.save(any())).thenReturn(movieEntity);
    this.service.addMovie(this.requestMock.getManagementMovieInsertRequest());
  }

  @Test
  public void addMoviesMapper() throws DuplicateMemberException {
    MovieEntity movieEntity = this.moviesMock.getMoviesEntity();
    when(this.repository.save(any())).thenReturn(movieEntity);
    when(this.requestMapper.mapTO((ManagementMovieInsertRequest) any())).thenReturn(movieEntity);
    this.service.addMovie(this.requestMock.getManagementMovieInsertRequest());
  }

  @Test
  public void addMovieDuplicateRule() throws DuplicateMemberException {
    exceptionRule.expect(DuplicateMemberException.class);
    when(this.repository.save(any())).thenThrow(new DataIntegrityViolationException("DUPLICATE"));
    this.service.addMovie(this.requestMock.getManagementMovieInsertRequest());
  }
}
