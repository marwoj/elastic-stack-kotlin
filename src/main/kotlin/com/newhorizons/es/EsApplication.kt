package com.newhorizons.es

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories

@SpringBootApplication(
	scanBasePackages = [
		"com.newhorizons.es"
	]
)
@EnableReactiveElasticsearchRepositories // TODO wojtek only scan selected packages
class EsApplication

fun main(args: Array<String>) {
	runApplication<EsApplication>(*args)
}
