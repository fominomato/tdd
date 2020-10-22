package com.pessoal.andre.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.mock.representation.ManagementMovieFindRequestMock;
import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.mapper.GestaoFilmesRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.repository.FilmesRepository;
import com.pessoal.andre.mock.representation.ManagementMovieFindResponseMock;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ManagementMovieSearchServiceTest {

  @InjectMocks
  private ManagementMovieSearchService searchService;

  @Mock
  private FilmesRepository filmesRepository;

  @Mock
  private GestaoFilmesRequestMapper requestMapper;

  private ManagementMovieFindRequestMock findRequestMock = new ManagementMovieFindRequestMock();

  private ManagementMovieFindResponseMock responseMock = new ManagementMovieFindResponseMock();

  private MoviesMock moviesMock = new MoviesMock();

  @Test
  public void pesquisaFilmes() {
    ManagementMovieFindByRequest request = this.findRequestMock.getGestaoFilmesFindRequest();
    request.setName(null);
    List<MoviesEntity> moviesEntityList = this.moviesMock.getListOfFilmesEntity(2000);
    when(this.filmesRepository.findAll()).thenReturn(moviesEntityList);
    when(this.requestMapper.mapTO((MoviesEntity) any())).thenReturn(this.responseMock.getGestaoFilmesFindByResponse(
        (moviesEntityList
            .stream()
            .filter(item ->
              (request.getGenre() != null && request.getGenre().equalsIgnoreCase(item.getGenre())) ||
              (request.getName() != null && request.getName().equalsIgnoreCase(item.getName()))
            )
            .findFirst()
        ).get()
    ));
    List<ManagementMovieFindByResponse> responseList = this.searchService.searchMovies(request);
    assertEquals(responseList.get(0).getGenero(), request.getGenre());
  }
}
