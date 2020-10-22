package com.pessoal.andre.mock.entity;

import com.pessoal.andre.models.entities.MoviesEntity;
import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class MoviesMock {

  private Faker faker;

  public MoviesEntity getFilmesEntity() {
    this.faker = new Faker();
    return this.generated();
  }

  public List<MoviesEntity> getListOfFilmesEntity(int numberOfElements) {
    this.faker = new Faker();
    List<MoviesEntity> entityList = new ArrayList<>();
    for (int c = 0; c < numberOfElements; c++) {
      entityList.add(this.generated());
    }
    return entityList;
  }

  private MoviesEntity generated() {
    MoviesEntity moviesEntity = new MoviesEntity();
    moviesEntity.setName(this.faker.pokemon().name());
    moviesEntity.setQuantity(this.faker.random().nextInt(1, 99));
    String[] generos = {"TERROR", "ROMANCE", "AVENTURA"};
    moviesEntity.setGenre(generos[this.faker.random().nextInt(0, 2)]);
    moviesEntity.setCreatedBy(this.faker.name().firstName());
    moviesEntity.setUpdatedBy(this.faker.name().firstName());

    Date dateBefore15Days = DateUtils.addDays(new Date(),-15);
    moviesEntity.setCreatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore15Days, new Date()).toInstant(),
        ZoneId.systemDefault()
    ));
    Date dateBefore10Days = DateUtils.addDays(new Date(),-10);
    moviesEntity.setUpdatedAt(
      LocalDateTime.ofInstant(this.faker.date().between(dateBefore10Days, new Date()).toInstant(),
          ZoneId.systemDefault()
    ));
    return moviesEntity;
  }
}
