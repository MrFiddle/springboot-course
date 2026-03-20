package org.example.springbootcourse.persistence.mapper

import org.mapstruct.Mapper
import org.mapstruct.Named

@Mapper(componentModel = "spring")
abstract class StateMapper {
    @Named("toBool")
    fun toBool(state: String): Boolean {
        return when (state.uppercase()) {
            "D" -> true
            "N" -> false
            else -> false
        }
    }
}