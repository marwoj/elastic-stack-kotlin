package com.newhorizons.es

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class MoviesService(private val moviesRepository: MoviesRepository) {
    fun findAll(): Flux<Movie> =
        moviesRepository.findAll().take(10)

    fun findByTitle(title: String): Flux<Movie> =
        moviesRepository.findByTitle(title).take(10)
}
