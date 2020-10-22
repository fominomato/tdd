package com.pessoal.andre.models.mapper;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import org.springframework.stereotype.Component;

@Component
public class GestaoFilmesRequestMapper {

  public MoviesEntity mapTO(ManagementMovieInsertRequest request) {
    MoviesEntity response = new MoviesEntity();
    response.setName(request.getNome());
    response.setGenre(request.getGenero().toUpperCase());
    response.setQuantity(request.getQuantidade());
    response.setCreatedBy("manuel"); //@todo quando implementar a autenticao o ideal será este dado vir de la
    return response;
  }

  public ManagementMovieFindByResponse mapTO(MoviesEntity moviesEntity) {
    ManagementMovieFindByResponse response = new ManagementMovieFindByResponse();
    response.setGenero(moviesEntity.getGenre());
    response.setNome(moviesEntity.getName());
    response.setQuantidade(moviesEntity.getQuantity());
    return response;
  }
}
