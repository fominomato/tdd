package com.pessoal.andre.models.representation;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class GestaoFilmesFindByRequest {

  @Size(min = 0, max = 255, message = "O Nome do filme não pode ultrapassar 255 caracteres!")
  private String nome;

  @Size(min = 3, max = 50, message = "Categoria de filme inválida para pesquisa!")
  private String genero;
}
