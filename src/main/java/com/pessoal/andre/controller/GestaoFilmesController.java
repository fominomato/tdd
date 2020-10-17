package com.pessoal.andre.controller;

import com.pessoal.andre.models.representation.GestaoFilmesFindByRequest;
import com.pessoal.andre.models.representation.GestaoFilmesFindByResponse;
import com.pessoal.andre.models.representation.GestaoFilmesInsertRequest;
import com.pessoal.andre.service.GestaoFilmesInsertService;
import com.pessoal.andre.service.GestaoFilmesSearchService;
import java.util.List;
import javassist.bytecode.DuplicateMemberException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gestao/filmes")
public class GestaoFilmesController {

  private final GestaoFilmesInsertService gestaoFilmesInsertService;

  private final GestaoFilmesSearchService gestaoFilmesSearchService;

  @Autowired
  public GestaoFilmesController(GestaoFilmesInsertService gestaoFilmesInsertService, GestaoFilmesSearchService gestaoFilmesSearchService) {
    this.gestaoFilmesInsertService = gestaoFilmesInsertService;
    this.gestaoFilmesSearchService = gestaoFilmesSearchService;
  }

  @PostMapping("/adiciona")
  public ResponseEntity<?> adicionaFilme(
      @RequestBody @Validated GestaoFilmesInsertRequest gestaoFilmesInsertRequest
  ) throws DuplicateMemberException {
      this.gestaoFilmesInsertService.registrarFilme(gestaoFilmesInsertRequest);
      return ResponseEntity.ok().body("sucess");
  }

  @GetMapping("/pesquisa")
  public ResponseEntity<List<GestaoFilmesFindByResponse>> pesquisaFilme(@Valid GestaoFilmesFindByRequest request) {
    return ResponseEntity.ok().body(this.gestaoFilmesSearchService.pesquisaFilmes(request));
  }
}
