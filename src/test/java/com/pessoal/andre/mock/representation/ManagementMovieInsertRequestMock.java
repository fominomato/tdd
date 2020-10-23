package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;

public class ManagementMovieInsertRequestMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieInsertRequest getGestaoFilmesInsertRequest() {
    ManagementMovieInsertRequest request = new ManagementMovieInsertRequest();
    request.setGenre(this.moviesMock.getFilmesEntity().getGenre());
    request.setName(this.moviesMock.getFilmesEntity().getName());
    request.setQuantity(this.moviesMock.getFilmesEntity().getQuantity());
    return request;
  }
}
