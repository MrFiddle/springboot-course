package org.example.springbootcourse.domain.exceptions

open class BusinessException(
    val errorCode: BusinessErrorCode,
    override val message: String = errorCode.message
) : RuntimeException(message)