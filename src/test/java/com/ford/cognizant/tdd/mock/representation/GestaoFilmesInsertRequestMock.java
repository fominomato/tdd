package com.ford.cognizant.tdd.mock.representation;

import com.ford.cognizant.tdd.mock.entity.FilmesMock;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesInsertRequest;

public class GestaoFilmesInsertRequestMock {

  private FilmesMock filmesMock = new FilmesMock();

  public GestaoFilmesInsertRequest getGestaoFilmesInsertRequest() {
    GestaoFilmesInsertRequest request = new GestaoFilmesInsertRequest();
    request.setGenero(this.filmesMock.getFilmesEntity().getGenero());
    request.setNome(this.filmesMock.getFilmesEntity().getNome());
    request.setQuantidade(this.filmesMock.getFilmesEntity().getQuantidade());
    return request;
  }
}
