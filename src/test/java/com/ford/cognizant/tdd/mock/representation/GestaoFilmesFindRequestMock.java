package com.ford.cognizant.tdd.mock.representation;

import com.ford.cognizant.tdd.mock.entity.FilmesMock;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByRequest;

public class GestaoFilmesFindRequestMock {

  private FilmesMock filmesMock = new FilmesMock();

  public GestaoFilmesFindByRequest getGestaoFilmesFindRequest() {
    GestaoFilmesFindByRequest request = new GestaoFilmesFindByRequest();
    request.setGenero(this.filmesMock.getFilmesEntity().getGenero());
    request.setNome(this.filmesMock.getFilmesEntity().getNome());
    return request;
  }
}
