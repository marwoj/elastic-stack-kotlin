package com.newhorizons.es

import org.elasticsearch.index.query.MultiMatchQueryBuilder
import org.elasticsearch.index.query.QueryBuilders.multiMatchQuery
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations
import org.springframework.data.elasticsearch.core.SearchHit
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux


@Repository
interface MoviesRepository : ReactiveCrudRepository<Movie, Long> {
    fun findByTitle(title: String): Flux<Movie>
}

interface CustomMovieRepository {
    fun multiFieldSearch(query: String): Flux<SearchHit<Movie>>
}

@Component
class CustomRepository(private val elasticSearchOperations: ReactiveElasticsearchOperations) : CustomMovieRepository {
    override fun multiFieldSearch(query: String): Flux<SearchHit<Movie>> {
        val nativeQuery = NativeSearchQueryBuilder()
            .withQuery(multiMatchQuery(query)
                .field("title")
                .field("genre")
                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
            .build()

        return elasticSearchOperations.search(nativeQuery, Movie::class.java)
    }
}

@Document(indexName = "movies")
data class Movie(
    @Id
    val id: Long,
    val title: String,
    val year: Long,
    val genre: List<String>
)
