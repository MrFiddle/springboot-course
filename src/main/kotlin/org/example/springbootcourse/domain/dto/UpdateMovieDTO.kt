package org.example.springbootcourse.domain.dto

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class UpdateMovieDTO(
    @get:Size(max = 150, message = "Title too long")
    val title: String,

    @get:DecimalMin(value = "0.0", message = "Rating must be positive")
    @get:DecimalMax(value = "5.0", message = "Max rating is 5")
    val rating: BigDecimal?,
    val state: Boolean = true,
)