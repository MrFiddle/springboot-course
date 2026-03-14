package org.example.springbootcourse.domain.service

import dev.langchain4j.service.UserMessage
import dev.langchain4j.service.spring.AiService

@AiService
interface PlatziPlayAIService {
    @UserMessage(
        """
            Genera un saludo de bienvenida a la plataforma de gestion de peliculas
            'PlatziPlay'. Usa menos de 120 caracteres y hazlo como si Leo Messi
            estuviera hablando
        """
    )
    fun generateGreeting(): String;
}