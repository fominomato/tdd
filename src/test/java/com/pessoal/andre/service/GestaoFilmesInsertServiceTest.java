package com.pessoal.andre.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.pessoal.andre.mock.entity.FilmesMock;
import com.pessoal.andre.models.entities.FilmesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.GestaoFilmesInsertRequest;
import com.pessoal.andre.repository.FilmesRepository;
import com.pessoal.andre.mock.representation.GestaoFilmesInsertRequestMock;
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
public class GestaoFilmesInsertServiceTest {

  @InjectMocks
  private GestaoFilmesInsertService service;

  @Mock
  private FilmesRepository repository;

  @Mock
  private GestaoFilmesRequestMapper requestMapper;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  private FilmesMock filmesMock = new FilmesMock();

  private GestaoFilmesInsertRequestMock requestMock = new GestaoFilmesInsertRequestMock();

  @Test
  public void registrarFilme() throws DuplicateMemberException {
    FilmesEntity filmesEntity = this.filmesMock.getFilmesEntity();
    when(this.repository.save(any())).thenReturn(filmesEntity);
    this.service.registrarFilme(this.requestMock.getGestaoFilmesInsertRequest());
  }

  @Test
  public void registrarFilmeSemMapper() throws DuplicateMemberException {
    FilmesEntity filmesEntity = this.filmesMock.getFilmesEntity();
    when(this.repository.save(any())).thenReturn(filmesEntity);
    when(this.requestMapper.mapTO((GestaoFilmesInsertRequest) any())).thenReturn(filmesEntity);
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