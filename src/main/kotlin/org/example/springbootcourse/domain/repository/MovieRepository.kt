package org.example.springbootcourse.domain.repository

import org.example.springbootcourse.domain.dto.CreateMovieDTO
import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.dto.UpdateMovieDTO

interface MovieRepository {
    fun getAll(): List<MovieDTO>
    fun getById(id: Long): MovieDTO?
    fun add(movieDTO: CreateMovieDTO): MovieDTO
    fun update(id: Long, movie: UpdateMovieDTO): MovieDTO
    fun delete(id: Long)
}