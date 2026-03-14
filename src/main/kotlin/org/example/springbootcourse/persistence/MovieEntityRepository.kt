package org.example.springbootcourse.persistence

import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.repository.MovieRepository
import org.example.springbootcourse.persistence.crud.MovieCrudRepository
import org.example.springbootcourse.persistence.mapper.MovieMapper
import org.springframework.stereotype.Repository

@Repository
class MovieEntityRepository(
    private val movieCrudRepository: MovieCrudRepository,
    private val movieMapper: MovieMapper
) : MovieRepository {
    override fun getAll(): List<MovieDTO> {
        return this.movieMapper.toDto(this.movieCrudRepository.findAll())
    }
}