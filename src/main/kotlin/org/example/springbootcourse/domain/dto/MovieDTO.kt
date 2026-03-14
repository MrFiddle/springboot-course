package org.example.springbootcourse.domain.dto

import java.time.LocalDate

data class MovieDTO(
    val title: String,
    val duration: Int,
    val genre: String,
    val releaseDate: LocalDate,
    val rating: Double
)