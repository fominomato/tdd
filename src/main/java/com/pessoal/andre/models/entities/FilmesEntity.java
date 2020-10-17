package com.pessoal.andre.models.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@NoArgsConstructor
@Table(name = "Filmes",  uniqueConstraints={
    @UniqueConstraint( name = "uq_nome",  columnNames ={"nome"})
  }
)
@Entity
public class FilmesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique=true)
  private String nome;

  private String genero;

  private int quantidade;

  @LastModifiedBy
  @Column(name = "updated_by")
  private String updatedBy;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @LastModifiedBy
  @Column(name = "created_by")
  private String createdBy;

  @LastModifiedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
