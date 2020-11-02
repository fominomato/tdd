package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.entities.MovieEntity;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;

public class ManagementMovieFindResponseMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieFindByResponse getGestaoFilmesFindByResponse(MovieEntity entity) {
    MovieEntity filme = entity;
    if (entity == null) {
      filme = this.moviesMock.getMoviesEntity();
    }
    ManagementMovieFindByResponse request = new ManagementMovieFindByResponse();
    request.setGenre(filme.getGenre());
    request.setName(filme.getName());
    request.setQuantity(filme.getQuantity());
    return request;
  }
}
