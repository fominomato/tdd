package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;

public class ManagementMovieInsertRequestMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieInsertRequest getManagementMovieInsertRequest() {
    ManagementMovieInsertRequest request = new ManagementMovieInsertRequest();
    request.setGenre(this.moviesMock.getMoviesEntity().getGenre());
    request.setName(this.moviesMock.getMoviesEntity().getName());
    request.setQuantity(this.moviesMock.getMoviesEntity().getQuantity());
    return request;
  }
}
