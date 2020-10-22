package com.pessoal.andre.controller;

import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.service.ManagementMovieInsertService;
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
public class ManagementMovieControllerTest {

  @InjectMocks
  private ManagementMovieController controller;

  @Mock
  private ManagementMovieInsertService service;

  @Test
  public void addFilme() throws DuplicateMemberException {
    doNothing().when(this.service).registrarFilme(any());
    this.controller.adicionaFilme(Mockito.mock(ManagementMovieInsertRequest.class));
  }

  @Test
  public void pesquisaFilme() {
    //@todo vamos implementar juntos
  }
}
