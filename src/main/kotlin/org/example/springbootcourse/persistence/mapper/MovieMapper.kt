package org.example.springbootcourse.persistence.mapper

import org.example.springbootcourse.domain.dto.CreateMovieDTO
import org.example.springbootcourse.domain.dto.MovieDTO
import org.example.springbootcourse.domain.dto.UpdateMovieDTO
import org.example.springbootcourse.persistence.entity.MovieEntity
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

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

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = ["genreToString"])
    @Mapping(source = "state", target = "estado", qualifiedByName = ["toState"])
    fun toEntity(dto: MovieDTO): MovieEntity;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "duration", target = "duracion")
    @Mapping(source = "genre", target = "genero", qualifiedByName = ["genreToString"])
    @Mapping(source = "releaseDate", target = "fechaEstreno")
    @Mapping(source = "rating", target = "clasificacion")
    @Mapping(source = "state", target = "estado", qualifiedByName = ["toState"])
    fun toEntity(dto: CreateMovieDTO): MovieEntity;

    @Mapping(target = "id", ignore = true) // Don't allow changing the ID
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "rating", target = "clasificacion")
    @Mapping(source = "state", target = "estado", qualifiedByName = ["toState"])
    // This updates the 'entity' object in place
    fun updateEntity(dto: UpdateMovieDTO, @MappingTarget entity: MovieEntity)
}