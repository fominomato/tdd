package com.pessoal.andre.models.representation;

import lombok.Data;

@Data
public class ManagementMovieInsertRequest {

  private String nome;

  private Integer quantidade;

  private String genero;

}
