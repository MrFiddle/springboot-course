package org.example.springbootcourse.domain.dto

import org.example.springbootcourse.domain.Genre
import java.time.LocalDate
import jakarta.validation.constraints.*

data class CreateMovieDTO(
    @get:NotBlank(message = "Title cannot be empty")
    @get:Size(max = 150, message = "Title too long")
    val title: String,

    @get:Positive(message = "Duration must be positive")
    val duration: Double,

    val genre: Genre?,

    @get:PastOrPresent(message = "Release date cannot be in the future")
    val releaseDate: LocalDate?,

    @get:DecimalMin(value = "0.0", message = "Rating must be positive")
    @get:DecimalMax(value = "10.0", message = "Max rating is 10")
    val rating: Double?,

    val state: Boolean = true,
)