package com.newhorizons.es

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EsApplication

fun main(args: Array<String>) {
	runApplication<EsApplication>(*args)
}
