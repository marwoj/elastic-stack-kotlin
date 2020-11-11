package com.newhorizons.es.testcontainers

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext

class ElasticInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    override fun initialize(context: ConfigurableApplicationContext) {
        println(ElasticsearchContainerSingleton.instance.httpHostAddress)
    }
}
