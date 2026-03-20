package org.example.springbootcourse.domain.dto

import org.example.springbootcourse.domain.Genre
import java.time.LocalDate

data class MovieDTO(
    val title: String,
    val duration: Double,
    val genre: Genre?,
    val releaseDate: LocalDate?,
    val rating: Double?,
    val state: Boolean,
)