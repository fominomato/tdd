package com.pessoal.andre.models.representation;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ManagementMovieFindByRequest {

  @Size(min = 0, max = 255, message = "O Nome do filme não pode ultrapassar 255 caracteres!")
  private String name;

  @Size(min = 3, max = 50, message = "Categoria de filme inválida para pesquisa!")
  private String genre;
}
