package org.example.springbootcourse.persistence.mapper

import org.example.springbootcourse.domain.Genre
import org.mapstruct.Mapper
import org.mapstruct.Named

@Mapper(componentModel = "spring")
abstract class GenreMapper {
    @Named("stringToGenre")
    fun stringToGenre(genre: String): Genre? {
        return when (genre.uppercase()) {
            "COMEDIA" -> Genre.COMEDY
            "DRAMA" -> Genre.DRAMA
            "ANIMADA" -> Genre.ANIMATED
            "TERROR" -> Genre.HORROR
            "CIENCIA_FICCION" -> Genre.SCI_FI
            else -> null
        }
    }

    @Named("genreToString")
    fun genreToString(genre: Genre): String? {
        return when (genre) {
            Genre.ACTION -> "ACCION"
            Genre.COMEDY -> "COMEDIA"
            Genre.DRAMA -> "DRAMA"
            Genre.ANIMATED -> "ANIMADA"
            Genre.HORROR -> "TERROR"
            Genre.SCI_FI -> "CIENCIA_FICCION"
        }
    }
}