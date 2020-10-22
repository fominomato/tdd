package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;

public class ManagementMovieFindResponseMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieFindByResponse getGestaoFilmesFindByResponse(MoviesEntity entity) {
    MoviesEntity filme = entity;
    if (entity == null) {
      filme = this.moviesMock.getFilmesEntity();
    }
    ManagementMovieFindByResponse request = new ManagementMovieFindByResponse();
    request.setGenero(filme.getGenre());
    request.setNome(filme.getName());
    request.setQuantidade(filme.getQuantity());
    return request;
  }
}
