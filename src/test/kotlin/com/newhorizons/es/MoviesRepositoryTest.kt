package com.newhorizons.es

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [EsApplication::class])
@AutoConfigureMockMvc
class MoviesRepositoryTest {

    @Autowired
    private lateinit var moviesRepository: MoviesRepository

    @Autowired
    private lateinit var customRepository: CustomRepository

    @Test
    fun testFindByTitle() {
        val movies = moviesRepository.findByTitle("Interstellar").take(1).collectList().block()!!
        println(ObjectMapper().writeValueAsString(movies))
    }

    @Test
    fun testMultiFieldSearch() {
        val genre = customRepository.multiFieldSearch("Sci-Fi").collectList().block()
        println(ObjectMapper().writeValueAsString(genre))

        val title = customRepository.multiFieldSearch("Interstellar").collectList().block()
        println(ObjectMapper().writeValueAsString(title))
    }
}
