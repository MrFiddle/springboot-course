package org.example.springbootcourse.web.controller

import jakarta.validation.Valid
import org.example.springbootcourse.domain.dto.CreateMovieDTO
import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.dto.UpdateMovieDTO
import org.example.springbootcourse.domain.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
    @GetMapping
    fun getAllMovies(): ResponseEntity<List<MovieDTO>> {
        val res = this.movieService.getAll()
        return ResponseEntity.ok(res)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<MovieDTO> {
        val res = this.movieService.getById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(res)
    }

    @PostMapping
    fun add(@Valid @RequestBody movieDTO: CreateMovieDTO): ResponseEntity<MovieDTO> {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieService.add(movieDTO))
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody movieDTO: UpdateMovieDTO
    ): ResponseEntity<MovieDTO> {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.update(id, movieDTO))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(movieService.delete(id))
    }
}