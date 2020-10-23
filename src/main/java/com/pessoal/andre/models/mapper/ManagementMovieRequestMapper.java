package com.pessoal.andre.models.mapper;

import com.pessoal.andre.models.entities.MovieEntity;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import org.springframework.stereotype.Component;

@Component
public class ManagementMovieRequestMapper {

  public MovieEntity mapTO(ManagementMovieInsertRequest request) {
    MovieEntity response = new MovieEntity();
    response.setName(request.getName());
    response.setGenre(request.getGenre().toUpperCase());
    response.setQuantity(request.getQuantity());
    response.setCreatedBy("manuel"); //@todo quando implementar a autenticao o ideal será este dado vir de la
    return response;
  }

  public ManagementMovieFindByResponse mapTO(MovieEntity movieEntity) {
    ManagementMovieFindByResponse response = new ManagementMovieFindByResponse();
    response.setGenre(movieEntity.getGenre());
    response.setName(movieEntity.getName());
    response.setQuantity(movieEntity.getQuantity());
    return response;
  }
}
