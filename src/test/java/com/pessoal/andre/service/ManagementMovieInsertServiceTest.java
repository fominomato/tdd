package com.pessoal.andre.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.repository.FilmesRepository;
import com.pessoal.andre.mock.representation.ManagementMovieInsertRequestMock;
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

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ManagementMovieInsertServiceTest {

  @InjectMocks
  private ManagementMovieInsertService service;

  @Mock
  private FilmesRepository repository;

  @Mock
  private GestaoFilmesRequestMapper requestMapper;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  private MoviesMock moviesMock = new MoviesMock();

  private ManagementMovieInsertRequestMock requestMock = new ManagementMovieInsertRequestMock();

  @Test
  public void registrarFilme() throws DuplicateMemberException {
    MoviesEntity moviesEntity = this.moviesMock.getFilmesEntity();
    when(this.repository.save(any())).thenReturn(moviesEntity);
    this.service.registrarFilme(this.requestMock.getGestaoFilmesInsertRequest());
  }

  @Test
  public void registrarFilmeSemMapper() throws DuplicateMemberException {
    MoviesEntity moviesEntity = this.moviesMock.getFilmesEntity();
    when(this.repository.save(any())).thenReturn(moviesEntity);
    when(this.requestMapper.mapTO((ManagementMovieInsertRequest) any())).thenReturn(moviesEntity);
    this.service.registrarFilme(this.requestMock.getGestaoFilmesInsertRequest());
  }

  @Test
  public void registrarFilmeDuplicateRule() throws DuplicateMemberException {
    exceptionRule.expect(DuplicateMemberException.class);
    when(this.repository.save(any())).thenThrow(new DataIntegrityViolationException("DUPLICATE"));
    this.service.registrarFilme(this.requestMock.getGestaoFilmesInsertRequest());
  }

  @Test
  public void pesquisaFilmes() {

  }
}
