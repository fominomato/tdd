package com.pessoal.andre.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name = "usuarios",  uniqueConstraints={
    @UniqueConstraint( name = "uq_usuarios",  columnNames ={"nome", "email"})
  }
)
@Entity
public class UsersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, name = "nome")
  private String name;

  @Column(name = "apelido")
  private String nickname;

  @Column(unique = true)
  private String email;

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
