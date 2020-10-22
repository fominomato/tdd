package com.pessoal.andre.mock.entity;

import com.pessoal.andre.models.entities.UsersEntity;
import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class UsersMock {

  private Faker faker;

  public UsersEntity getUsuariosEntity() {
    this.faker = new Faker();
    return this.generated();
  }

  public List<UsersEntity> getListOfUsuariosEntity(int numberOfElements) {
    this.faker = new Faker();
    List<UsersEntity> entityList = new ArrayList<>();
    for (int c = 0; c < numberOfElements; c++) {
      entityList.add(this.generated());
    }
    return entityList;
  }

  private UsersEntity generated() {
    UsersEntity usersEntity = new UsersEntity();
    usersEntity.setName(this.faker.name().firstName());
    usersEntity.setNickname(this.faker.witcher().character());
    usersEntity.setEmail(this.faker.internet().safeEmailAddress());

    Date dateBefore = DateUtils.addDays(new Date(),-30);
    usersEntity.setCreatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore, new Date()).toInstant(),
            ZoneId.systemDefault()
        ));
    Date dateBefore10Days = DateUtils.addDays(new Date(),-10);
    usersEntity.setUpdatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore10Days, new Date()).toInstant(),
            ZoneId.systemDefault()
        ));
    return usersEntity;
  }
}
