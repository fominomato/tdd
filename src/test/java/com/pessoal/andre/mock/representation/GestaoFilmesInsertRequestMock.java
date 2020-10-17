package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.FilmesMock;
import com.pessoal.andre.models.representation.GestaoFilmesInsertRequest;

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
