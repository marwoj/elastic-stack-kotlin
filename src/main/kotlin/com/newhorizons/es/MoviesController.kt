package com.newhorizons.es

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/movies")
class MoviesController(private val moviesService: MoviesService) {
    @GetMapping
    fun findMoviesByTitle(
        @RequestParam title: String
    ): Flux<Movie> =
        moviesService.findByTitle(title)
}
