package org.example.springbootcourse.web.exception

import org.example.springbootcourse.domain.exceptions.BusinessException
import org.example.springbootcourse.domain.exceptions.ResourceNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFound(ex: ResourceNotFoundException): ProblemDetail {
        // ProblemDetail is a standard for error responses (RFC 7807) supported in Spring Boot 3
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.message ?: "Resource not found")
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationErrors(ex: MethodArgumentNotValidException): ProblemDetail {
        val errors = ex.bindingResult.fieldErrors
            .associate { it.field to it.defaultMessage }

        val problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Validation failed")
        problem.setProperty("errors", errors) // Add the specific field errors to the response
        return problem
    }

    private val constraintMessages = mapOf(
        "unique_movie_title" to "A movie with this title already exists.", // Or use the meaningful name
        "uk_user_email" to "This email is already in use.",
        "fk_genre_id" to "The selected genre is invalid."
    )

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleConflict(ex: DataIntegrityViolationException): ProblemDetail {
        val message = constraintMessages.entries.find { ex.message?.contains(it.key) == true }?.value
            ?: "A database constraint was violated."

        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, message)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException): ProblemDetail {
        val problem = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST, // Or map HttpStatus to the enum as well
            ex.message
        )
        problem.setProperty("error_code", ex.errorCode.code) // Client now gets "E001"
        return problem
    }
}