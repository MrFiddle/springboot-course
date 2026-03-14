package org.example.springbootcourse.domain.repository

import org.example.springbootcourse.domain.dto.MovieDTO

interface MovieRepository {
    fun getAll(): List<MovieDTO>
}