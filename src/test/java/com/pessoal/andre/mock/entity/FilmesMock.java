package com.pessoal.andre.mock.entity;

import com.pessoal.andre.models.entities.FilmesEntity;
import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class FilmesMock {

  private Faker faker;

  public FilmesEntity getFilmesEntity() {
    this.faker = new Faker();
    return this.generated();
  }

  public List<FilmesEntity> getListOfFilmesEntity(int numberOfElements) {
    this.faker = new Faker();
    List<FilmesEntity> entityList = new ArrayList<>();
    for (int c = 0; c < numberOfElements; c++) {
      entityList.add(this.generated());
    }
    return entityList;
  }

  private FilmesEntity generated() {
    FilmesEntity filmesEntity = new FilmesEntity();
    filmesEntity.setNome(this.faker.pokemon().name());
    filmesEntity.setQuantidade(this.faker.random().nextInt(1, 99));
    String[] generos = {"TERROR", "ROMANCE", "AVENTURA"};
    filmesEntity.setGenero(generos[this.faker.random().nextInt(0, 2)]);
    filmesEntity.setCreatedBy(this.faker.name().firstName());
    filmesEntity.setUpdatedBy(this.faker.name().firstName());

    Date dateBefore15Days = DateUtils.addDays(new Date(),-15);
    filmesEntity.setCreatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore15Days, new Date()).toInstant(),
        ZoneId.systemDefault()
    ));
    Date dateBefore10Days = DateUtils.addDays(new Date(),-10);
    filmesEntity.setUpdatedAt(
      LocalDateTime.ofInstant(this.faker.date().between(dateBefore10Days, new Date()).toInstant(),
          ZoneId.systemDefault()
    ));
    return filmesEntity;
  }
}
