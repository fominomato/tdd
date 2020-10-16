package com.ford.cognizant.tdd.mock.representation;

import com.ford.cognizant.tdd.mock.entity.FilmesMock;
import com.ford.cognizant.tdd.models.entities.FilmesEntity;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByResponse;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesInsertRequest;

public class GestaoFilmesFindResponseMock {

  private FilmesMock filmesMock = new FilmesMock();

  public GestaoFilmesFindByResponse getGestaoFilmesFindByResponse(FilmesEntity entity) {
    FilmesEntity filme = entity;
    if (entity == null) {
      filme = this.filmesMock.getFilmesEntity();
    }
    GestaoFilmesFindByResponse request = new GestaoFilmesFindByResponse();
    request.setGenero(filme.getGenero());
    request.setNome(filme.getNome());
    request.setQuantidade(filme.getQuantidade());
    return request;
  }
}
