DROP TABLE IF EXISTS filmes;

CREATE TABLE filmes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  genero VARCHAR(250) NOT NULL,
  quantidade INTEGER(4) DEFAULT 0,
  created_by VARCHAR(250) NOT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP ,
  updated_by VARCHAR(250),
  updated_at DATETIME
);

ALTER TABLE filmes ADD UNIQUE (nome);

INSERT INTO filmes (nome, genero, quantidade, created_by) VALUES
  ('Aliko', 'TERROR', 20, 'andre'),
  ('FILME 2', 'PORRADARIA', 36, 'andre'),
  ('TRAPALHADAS', 'HUMOR', 3, 'andre');

DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  apelido VARCHAR(250) NOT NULL,
  email VARCHAR(255) NOT NULL,
  created_by VARCHAR(250) NOT NULL,
  created_at DATETIME  DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME ,
  updated_by VARCHAR(250)
);

ALTER TABLE usuarios ADD UNIQUE (nome, email);

INSERT INTO usuarios (nome, apelido, email, created_by) VALUES ('Andre', 'andre', 'aguarie1@ford.com', 'sistema');
