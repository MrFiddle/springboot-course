package org.example.springbootcourse.domain.service

import org.example.springbootcourse.domain.dto.CreateMovieDTO
import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.dto.UpdateMovieDTO
import org.example.springbootcourse.domain.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {

    fun getAll(): List<MovieDTO> {
        return this.movieRepository.getAll()
    }

    fun getById(id: Long): MovieDTO? {
        return this.movieRepository.getById(id)
    }

    fun add(movieDTO: CreateMovieDTO): MovieDTO {
        return this.movieRepository.add(movieDTO)
    }

    fun update(id: Long, movie: UpdateMovieDTO): MovieDTO {
        return this.movieRepository.update(id, movie)
    }
}