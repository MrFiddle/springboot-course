package org.example.springbootcourse.persistence.crud

import org.example.springbootcourse.persistence.entity.MovieEntity
import org.springframework.data.repository.CrudRepository

interface MovieCrudRepository : CrudRepository<MovieEntity, Long> {
}