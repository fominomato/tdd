package com.pessoal.andre.mock.representation;

import com.pessoal.andre.mock.entity.FilmesMock;
import com.pessoal.andre.models.entities.FilmesEntity;
import com.pessoal.andre.models.representation.GestaoFilmesFindByResponse;

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
