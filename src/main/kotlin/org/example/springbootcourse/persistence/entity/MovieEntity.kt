package org.example.springbootcourse.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "platzi_play_peliculas")
class MovieEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(
        nullable = false,
        length = 150,
        unique = true
    )
    var titulo: String,

    @Column(
        nullable = false,
        precision = 3
    )
    var duracion: Double,

    @Column(
        nullable = false,
        length = 40,
    )
    var genero: String,

    @Column(
        name = "fecha_estreno",
        nullable = true,
    )
    var fechaEstreno: LocalDate? = null,

    @Column(
        nullable = true,
        precision = 3,
        scale = 2
    )
    var clasificacion: BigDecimal? = null,

    @Column(
        nullable = false,
        length = 1,
    )
    var estado: String
)