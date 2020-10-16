package com.ford.cognizant.tdd.models.mapper;

import com.ford.cognizant.tdd.models.entities.FilmesEntity;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesInsertRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

//@todo Este teste não implementa o RunWith então devemos inicializar o mockito
public class GestaoFilmesRequestMapperTest {

  @InjectMocks
  private GestaoFilmesRequestMapper requestMapper;

  @Before
  public void executaAntes() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void mapTO() {
    FilmesEntity entity = this.requestMapper.mapTO(this.getGestaoFilmesInsertRequest());
    Assert.assertEquals(entity.getGenero(), this.getGestaoFilmesInsertRequest().getGenero());
  }

  private GestaoFilmesInsertRequest getGestaoFilmesInsertRequest() {
    GestaoFilmesInsertRequest response = new GestaoFilmesInsertRequest();
    response.setNome("TESTE");
    response.setGenero("TECNOLOGIA");
    response.setQuantidade(10);
    return response;
  }

  @Test
  public void testMapTO() {
    //@todo vamos montar este
  }
}
