package com.pessoal.andre.models.mapper;

import com.pessoal.andre.models.entities.FilmesEntity;
import com.pessoal.andre.models.representation.GestaoFilmesFindByResponse;
import com.pessoal.andre.models.representation.GestaoFilmesInsertRequest;
import org.springframework.stereotype.Component;

@Component
public class GestaoFilmesRequestMapper {

  public FilmesEntity mapTO(GestaoFilmesInsertRequest request) {
    FilmesEntity response = new FilmesEntity();
    response.setNome(request.getNome());
    response.setGenero(request.getGenero().toUpperCase());
    response.setQuantidade(request.getQuantidade());
    response.setCreatedBy("manuel"); //@todo quando implementar a autenticao o ideal será este dado vir de la
    return response;
  }

  public GestaoFilmesFindByResponse mapTO(FilmesEntity filmesEntity) {
    GestaoFilmesFindByResponse response = new GestaoFilmesFindByResponse();
    response.setGenero(filmesEntity.getGenero());
    response.setNome(filmesEntity.getNome());
    response.setQuantidade(filmesEntity.getQuantidade());
    return response;
  }
}
