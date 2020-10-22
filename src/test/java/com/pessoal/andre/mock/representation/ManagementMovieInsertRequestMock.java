package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;

public class ManagementMovieInsertRequestMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieInsertRequest getGestaoFilmesInsertRequest() {
    ManagementMovieInsertRequest request = new ManagementMovieInsertRequest();
    request.setGenero(this.moviesMock.getFilmesEntity().getGenre());
    request.setNome(this.moviesMock.getFilmesEntity().getName());
    request.setQuantidade(this.moviesMock.getFilmesEntity().getQuantity());
    return request;
  }
}
