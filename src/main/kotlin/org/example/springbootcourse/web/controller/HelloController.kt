package org.example.springbootcourse.web.controller

import org.example.springbootcourse.domain.service.PlatziPlayAIService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val aiService: PlatziPlayAIService
) {
    @GetMapping("/hello")
    fun hello(): String {
        return this.aiService.generateGreeting()
    }

    @GetMapping("/hello2")
    fun hello2(): String {
        return "Hola !!"
    }
}