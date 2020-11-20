package com.pessoal.andre.integrations.controller;

import com.pessoal.andre.models.entities.MovieEntity;
import com.pessoal.andre.repository.MoviesRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ManagementMovieControllerIntegration {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private MoviesRepository moviesRepository;

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().basicAuthentication("user", "pass");
        }
    }

    @Test
    public void listMoviesWhenSearchByCategoryTerrorShouldReturnStatusCode200() {
        String genre = "TERROR";
        String name = "Aliko";
        List<MovieEntity> moviesList = Arrays.asList(
                new MovieEntity(1L, "Filme de medo", "TERROR", 20, "aguarie1", LocalDateTime.now(), "aguarie1", LocalDateTime.now()),
                new MovieEntity(2L, "Filme de medo", "AMOR", 20, "aguarie1", LocalDateTime.now(), "aguarie1", LocalDateTime.now())
        );
        BDDMockito.when(this.moviesRepository.findAll()).thenReturn(moviesList);
        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/v1/gestao/filmes/?genre={genre}&name={name}", String.class, genre, name);
        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(200);
    }

    @Test
    public void listMoviesWhenSearchByWithoutNameShouldReturnStatusCode400() {
        String genre = "TERROR";
        String name = "";
        List<MovieEntity> moviesList = Arrays.asList(
                new MovieEntity(1L, "Filme de medo", "TERROR", 20, "aguarie1", LocalDateTime.now(), "aguarie1", LocalDateTime.now()),
                new MovieEntity(2L, "Filme de medo", "AMOR", 20, "aguarie1", LocalDateTime.now(), "aguarie1", LocalDateTime.now())
        );
        BDDMockito.when(this.moviesRepository.findAll()).thenReturn(moviesList);
        ResponseEntity<String> response = this.restTemplate.getForEntity("/api/v1/gestao/filmes/?genre={genre}&name={name}", String.class, genre, name);
        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(400);
    }
}
