package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;

public class ManagementMovieFindRequestMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieFindByRequest getManagementMovieFindRequest() {
    ManagementMovieFindByRequest request = new ManagementMovieFindByRequest();
    request.setGenre(this.moviesMock.getMoviesEntity().getGenre());
    request.setName(this.moviesMock.getMoviesEntity().getName());
    return request;
  }
}
