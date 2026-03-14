package org.example.springbootcourse.domain.service

import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {

    fun getAll(): List<MovieDTO> {
        return this.movieRepository.getAll()
    }

}