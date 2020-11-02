package com.pessoal.andre.service;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.mock.representation.ManagementMovieFindRequestMock;
import com.pessoal.andre.mock.representation.ManagementMovieFindResponseMock;
import com.pessoal.andre.models.entities.MovieEntity;
import com.pessoal.andre.models.mapper.ManagementMovieRequestMapper;
import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.repository.MoviesRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ManagementMovieSearchServiceTest {

  @InjectMocks
  private ManagementMovieSearchService searchService;

  @Mock
  private MoviesRepository moviesRepository;

  @Mock
  private ManagementMovieRequestMapper requestMapper;

  private ManagementMovieFindRequestMock findRequestMock = new ManagementMovieFindRequestMock();

  private ManagementMovieFindResponseMock responseMock = new ManagementMovieFindResponseMock();

  private MoviesMock moviesMock = new MoviesMock();

  @Test
  public void searchMovies() {
    ManagementMovieFindByRequest request = this.findRequestMock.getManagementMovieFindRequest();
    request.setName(null);
    List<MovieEntity> movieEntityList = this.moviesMock.getListOfMoviesEntity(2000);
    when(this.moviesRepository.findAll()).thenReturn(movieEntityList);
    when(this.requestMapper.mapTO((MovieEntity) any())).thenReturn(this.responseMock.getGestaoFilmesFindByResponse(
        (movieEntityList
            .stream()
            .filter(item ->
              (request.getGenre() != null && request.getGenre().equalsIgnoreCase(item.getGenre())) ||
              (request.getName() != null && request.getName().equalsIgnoreCase(item.getName()))
            )
            .findFirst()
        ).get()
    ));
    List<ManagementMovieFindByResponse> responseList = this.searchService.searchMovies(request);
    assertEquals(responseList.get(0).getGenre(), request.getGenre());
  }
}
