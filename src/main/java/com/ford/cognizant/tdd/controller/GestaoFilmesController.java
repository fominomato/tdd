package com.ford.cognizant.tdd.controller;

import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByRequest;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesFindByResponse;
import com.ford.cognizant.tdd.models.representation.GestaoFilmesInsertRequest;
import com.ford.cognizant.tdd.service.GestaoFilmesInsertService;
import com.ford.cognizant.tdd.service.GestaoFilmesSearchService;
import java.util.List;
import javassist.bytecode.DuplicateMemberException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gestao/filmes")
@RequiredArgsConstructor
public class GestaoFilmesController {

  private final GestaoFilmesInsertService gestaoFilmesInsertService;

  private final GestaoFilmesSearchService gestaoFilmesSearchService;

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
