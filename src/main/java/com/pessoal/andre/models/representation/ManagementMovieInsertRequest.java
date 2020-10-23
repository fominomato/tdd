package com.pessoal.andre.models.representation;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ManagementMovieInsertRequest {

  @NotBlank(message = "O campo nome não epode ser vazio!")
  @Size(min = 2, max = 250, message = "O campo nome esta inválido!")
  private String name;

  @NotBlank(message = "Por favor informar a quantidade")
  @Max(value = 99, message = "O valor da quantidade não pode ser maior que 99!")
  @Min(value = 1, message = "O valor da quantidade não pode ser inferior a 1!")
  private Integer quantity;

  @NotBlank(message = "Por favor informar o gênero!")
  @Size(min = 2, max = 20, message = "O campo gênero esta inválido!")
  private String genre;

}
