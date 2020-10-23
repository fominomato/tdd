package com.pessoal.andre.models.representation;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ManagementMovieFindByRequest {

  @Size(min = 2, max = 255, message = "O Nome do filme deve ter entre 2 e 255 caracteres!")
  private String name;

  @Size(min = 3, max = 50, message = "Categoria de filme inválida para pesquisa!")
  private String genre;
}
