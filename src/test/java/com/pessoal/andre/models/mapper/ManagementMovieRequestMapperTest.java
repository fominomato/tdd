package com.pessoal.andre.models.mapper;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

//@todo Este teste não implementa o RunWith então devemos inicializar o mockito
public class ManagementMovieRequestMapperTest {

  @InjectMocks
  private GestaoFilmesRequestMapper requestMapper;

  @Before
  public void executaAntes() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void mapTO() {
    MoviesEntity entity = this.requestMapper.mapTO(this.getGestaoFilmesInsertRequest());
    Assert.assertEquals(entity.getGenre(), this.getGestaoFilmesInsertRequest().getGenre());
  }

  private ManagementMovieInsertRequest getGestaoFilmesInsertRequest() {
    ManagementMovieInsertRequest response = new ManagementMovieInsertRequest();
    response.setName("TESTE");
    response.setGenre("TECNOLOGIA");
    response.setQuantity(10);
    return response;
  }

  @Test
  public void testMapTO() {
    //@todo vamos montar este
  }
}
