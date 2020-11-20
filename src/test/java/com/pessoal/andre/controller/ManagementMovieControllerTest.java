package com.pessoal.andre.controller;

import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.services.ManagementMovieInsertService;
import javassist.bytecode.DuplicateMemberException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ManagementMovieControllerTest {

  @InjectMocks
  private ManagementMovieController controller;

  @Mock
  private ManagementMovieInsertService service;

  @Test
  public void addMovie() throws DuplicateMemberException {
    doNothing().when(this.service).addMovie(any());
    this.controller.addMovie(Mockito.mock(ManagementMovieInsertRequest.class));
  }
}
