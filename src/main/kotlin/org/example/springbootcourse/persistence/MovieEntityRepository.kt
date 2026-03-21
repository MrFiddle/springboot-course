package org.example.springbootcourse.persistence

import org.example.springbootcourse.domain.dto.CreateMovieDTO
import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.dto.UpdateMovieDTO
import org.example.springbootcourse.domain.exceptions.ResourceNotFoundException
import org.example.springbootcourse.domain.repository.MovieRepository
import org.example.springbootcourse.persistence.crud.MovieCrudRepository
import org.example.springbootcourse.persistence.mapper.MovieMapper
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class MovieEntityRepository(
    private val movieCrudRepository: MovieCrudRepository,
    private val movieMapper: MovieMapper
) : MovieRepository {
    override fun getAll(): List<MovieDTO> {
        return this.movieMapper.toDto(this.movieCrudRepository.findAll())
    }

    override fun getById(id: Long): MovieDTO? {
        val movieEntity = this.movieCrudRepository.findById(id)
            .map(movieMapper::toDto)
            .orElseThrow {
                ResourceNotFoundException("Movie not found with id: $id")
            }

        return movieEntity
    }

    override fun add(movieDTO: CreateMovieDTO): MovieDTO {
        val movieEntity = this.movieMapper.toEntity(movieDTO)

        return this.movieMapper.toDto(this.movieCrudRepository.save(movieEntity))
    }

    override fun update(id: Long, movie: UpdateMovieDTO): MovieDTO {
        val existingEntity = this.movieCrudRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Movie not found with id: $id") }

        // MapStruct handles all the field mapping logic here
        this.movieMapper.updateEntity(movie, existingEntity)

        return this.movieMapper.toDto(this.movieCrudRepository.save(existingEntity))
    }
}