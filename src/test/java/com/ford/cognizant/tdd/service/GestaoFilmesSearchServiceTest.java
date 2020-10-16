package com.ford.cognizant.tdd.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ford.cognizant.tdd.mock.entity.FilmesMock;
import com.ford.cognizant.tdd.mock.representation.GestaoFilmesFindRequestMock;
import com.ford.cognizant.tdd.mock.representation.GestaoFilmesFindResponseMock;
import com.ford.cognizant.tdd.models.entities.FilmesEntity;
import com.ford.cognizant.tdd.models.mapper.GestaoFilmesRequestMapper;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByRequest;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByResponse;
import com.ford.cognizant.tdd.repository.FilmesRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class GestaoFilmesSearchServiceTest {

  @InjectMocks
  private GestaoFilmesSearchService searchService;

  @Mock
  private FilmesRepository filmesRepository;

  @Mock
  private GestaoFilmesRequestMapper requestMapper;

  private GestaoFilmesFindRequestMock findRequestMock = new GestaoFilmesFindRequestMock();

  private GestaoFilmesFindResponseMock responseMock = new GestaoFilmesFindResponseMock();

  private FilmesMock filmesMock = new FilmesMock();

  @Test
  public void pesquisaFilmes() {
    GestaoFilmesFindByRequest request = this.findRequestMock.getGestaoFilmesFindRequest();
    request.setNome(null);
    List<FilmesEntity> filmesEntityList = this.filmesMock.getListOfFilmesEntity(2000);
    when(this.filmesRepository.findAll()).thenReturn(filmesEntityList);
    when(this.requestMapper.mapTO((FilmesEntity) any())).thenReturn(this.responseMock.getGestaoFilmesFindByResponse(
        (filmesEntityList
            .stream()
            .filter(item ->
              (request.getGenero() != null && request.getGenero().equalsIgnoreCase(item.getGenero())) ||
              (request.getNome() != null && request.getNome().equalsIgnoreCase(item.getNome()))
            )
            .findFirst()
        ).get()
    ));
    List<GestaoFilmesFindByResponse> responseList = this.searchService.pesquisaFilmes(request);
    assertEquals(responseList.get(0).getGenero(), request.getGenero());
  }
}
