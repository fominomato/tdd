package com.pessoal.andre.mock.entity;

import com.pessoal.andre.models.entities.UsuariosEntity;
import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class UsuariosMock {

  private Faker faker;

  public UsuariosEntity getUsuariosEntity() {
    this.faker = new Faker();
    return this.generated();
  }

  public List<UsuariosEntity> getListOfUsuariosEntity(int numberOfElements) {
    this.faker = new Faker();
    List<UsuariosEntity> entityList = new ArrayList<>();
    for (int c = 0; c < numberOfElements; c++) {
      entityList.add(this.generated());
    }
    return entityList;
  }

  private UsuariosEntity generated() {
    UsuariosEntity usuariosEntity = new UsuariosEntity();
    usuariosEntity.setNome(this.faker.name().firstName());
    usuariosEntity.setApelido(this.faker.witcher().character());
    usuariosEntity.setEmail(this.faker.internet().safeEmailAddress());

    Date dateBefore = DateUtils.addDays(new Date(),-30);
    usuariosEntity.setCreatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore, new Date()).toInstant(),
            ZoneId.systemDefault()
        ));
    Date dateBefore10Days = DateUtils.addDays(new Date(),-10);
    usuariosEntity.setUpdatedAt(
        LocalDateTime.ofInstant(this.faker.date().between(dateBefore10Days, new Date()).toInstant(),
            ZoneId.systemDefault()
        ));
    return usuariosEntity;
  }
}
