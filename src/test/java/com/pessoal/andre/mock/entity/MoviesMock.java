package com.pessoal.andre.mock.entity;

import com.github.javafaker.Faker;
import com.pessoal.andre.models.entities.MovieEntity;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoviesMock {

  private Faker faker;

  public MovieEntity getMoviesEntity() {
    this.faker = new Faker();
    return this.generated();
  }

  public List<MovieEntity> getListOfMoviesEntity(int numberOfElements) {
    this.faker = new Faker();
    List<MovieEntity> entityList = new ArrayList<>();
    for (int c = 0; c < numberOfElements; c++) {
      entityList.add(this.generated());
    }
    return entityList;
  }

  private MovieEntity generated() {
    MovieEntity movieEntity = new MovieEntity();
    movieEntity.setName(this.faker.pokemon().name());
    movieEntity.setQuantity(this.faker.random().nextInt(1, 99));
    String[] generos = {"TERROR", "ROMANCE", "AVENTURA"};
    movieEntity.setGenre(generos[this.faker.random().nextInt(0, 2)]);
    movieEntity.setCreatedBy(this.faker.name().firstName());
    movieEntity.setUpdatedBy(this.faker.name().firstName());

    Date dateBefore15Days = DateUtils.addDays(new Date(),-15);
    movieEntity.setCreatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore15Days, new Date()).toInstant(),
        ZoneId.systemDefault()
    ));
    Date dateBefore10Days = DateUtils.addDays(new Date(),-10);
    movieEntity.setUpdatedAt(
      LocalDateTime.ofInstant(this.faker.date().between(dateBefore10Days, new Date()).toInstant(),
          ZoneId.systemDefault()
    ));
    return movieEntity;
  }
}
