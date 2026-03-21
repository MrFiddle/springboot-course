package org.example.springbootcourse.domain.exceptions

enum class BusinessErrorCode(val code: String, val message: String) {
    MOVIE_ALREADY_EXISTS("E001", "A movie with this title already exists."),
    MOVIE_NOT_FOUND("E002", "The requested movie was not found !!!"),
    INVALID_GENRE("E003", "The provided genre is not supported."),
    ACTION_FORBIDDEN("E004", "This action is not allowed for this item.")
}