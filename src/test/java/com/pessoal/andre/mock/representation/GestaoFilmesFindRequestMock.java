package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.FilmesMock;
import com.pessoal.andre.models.representation.GestaoFilmesFindByRequest;

public class GestaoFilmesFindRequestMock {

  private FilmesMock filmesMock = new FilmesMock();

  public GestaoFilmesFindByRequest getGestaoFilmesFindRequest() {
    GestaoFilmesFindByRequest request = new GestaoFilmesFindByRequest();
    request.setGenero(this.filmesMock.getFilmesEntity().getGenero());
    request.setNome(this.filmesMock.getFilmesEntity().getNome());
    return request;
  }
}
