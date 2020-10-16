package com.ford.cognizant.tdd.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import com.ford.cognizant.tdd.models.representation.GestaoFilmesInsertRequest;
import com.ford.cognizant.tdd.service.GestaoFilmesInsertService;
import javassist.bytecode.DuplicateMemberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
