package com.pessoal.andre.controller;

import com.pessoal.andre.models.representation.GestaoFilmesInsertRequest;
import com.pessoal.andre.service.GestaoFilmesInsertService;
import javassist.bytecode.DuplicateMemberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class GestaoFilmesControllerTest {

  @InjectMocks
  private GestaoFilmesController controller;

  @Mock
  private GestaoFilmesInsertService service;

  @Test
  public void addFilme() throws DuplicateMemberException {
    doNothing().when(this.service).registrarFilme(any());
    this.controller.adicionaFilme(Mockito.mock(GestaoFilmesInsertRequest.class));
  }

  @Test
  public void pesquisaFilme() {
    //@todo vamos implementar juntos
  }
}
