package com.pessoal.andre.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name = "Filmes",  uniqueConstraints={
    @UniqueConstraint( name = "uq_nome",  columnNames ={"nome"})
  }
)
@Entity
public class MovieEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique=true, name = "nome")
  private String name;

  @Column(name = "genero")
  private String genre;

  @Column(name = "quantidade")
  private int quantity;

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
