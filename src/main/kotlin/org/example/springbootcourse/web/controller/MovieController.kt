package org.example.springbootcourse.web.controller

import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
    @GetMapping
    fun getAllMovies(): List<MovieDTO> {
        return this.movieService.getAll()
    }
}