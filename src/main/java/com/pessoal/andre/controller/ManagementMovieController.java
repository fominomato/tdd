package com.pessoal.andre.controller;

import com.pessoal.andre.models.representation.ManagementMovieFindByRequest;
import com.pessoal.andre.models.representation.ManagementMovieFindByResponse;
import com.pessoal.andre.models.representation.ManagementMovieInsertRequest;
import com.pessoal.andre.service.ManagementMovieInsertService;
import com.pessoal.andre.service.ManagementMovieSearchService;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gestao/filmes")
@RequiredArgsConstructor
public class ManagementMovieController {

  private final ManagementMovieInsertService managementMovieInsertService;

  private final ManagementMovieSearchService managementMovieSearchService;

  @PostMapping("/")
  public ResponseEntity<?> addMovie(
      @RequestBody @Validated ManagementMovieInsertRequest managementMovieInsertRequest
  ) throws DuplicateMemberException {
      this.managementMovieInsertService.addMovie(managementMovieInsertRequest);
      return ResponseEntity.ok().body("sucess");
  }

  @GetMapping("/")
  public ResponseEntity<List<ManagementMovieFindByResponse>> searchMoviesBy(@Valid ManagementMovieFindByRequest request) {
    return ResponseEntity.ok().body(this.managementMovieSearchService.searchMovies(request));
  }
}
