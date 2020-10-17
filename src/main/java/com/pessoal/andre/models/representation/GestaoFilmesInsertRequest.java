package com.pessoal.andre.models.representation;

import lombok.Data;

@Data
public class GestaoFilmesInsertRequest {

  private String nome;

  private Integer quantidade;

  private String genero;

}
