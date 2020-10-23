package com.pessoal.andre.models.mapper;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import org.springframework.stereotype.Component;

@Component
public class GestaoFilmesRequestMapper {

  public MoviesEntity mapTO(ManagementMovieInsertRequest request) {
    MoviesEntity response = new MoviesEntity();
    response.setName(request.getName());
    response.setGenre(request.getGenre().toUpperCase());
    response.setQuantity(request.getQuantity());
    response.setCreatedBy("manuel"); //@todo quando implementar a autenticao o ideal será este dado vir de la
    return response;
  }

  public ManagementMovieFindByResponse mapTO(MoviesEntity moviesEntity) {
    ManagementMovieFindByResponse response = new ManagementMovieFindByResponse();
    response.setGenre(moviesEntity.getGenre());
    response.setName(moviesEntity.getName());
    response.setQuantity(moviesEntity.getQuantity());
    return response;
  }
}
