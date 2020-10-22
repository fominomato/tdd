package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.MoviesMock;
import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;

public class ManagementMovieFindRequestMock {

  private MoviesMock moviesMock = new MoviesMock();

  public ManagementMovieFindByRequest getGestaoFilmesFindRequest() {
    ManagementMovieFindByRequest request = new ManagementMovieFindByRequest();
    request.setGenre(this.moviesMock.getFilmesEntity().getGenre());
    request.setName(this.moviesMock.getFilmesEntity().getName());
    return request;
  }
}
