package org.example.springbootcourse.persistence.mapper

import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.persistence.entity.MovieEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", uses = [GenreMapper::class, StateMapper::class])
interface MovieMapper {
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = ["stringToGenre"])
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    @Mapping(source = "estado", target = "state", qualifiedByName = ["toBool"])
    fun toDto(entity: MovieEntity): MovieDTO;
    fun toDto(entities: Iterable<MovieEntity>): List<MovieDTO>;
}