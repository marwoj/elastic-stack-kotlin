package com.newhorizons.es.testcontainers

import org.testcontainers.elasticsearch.ElasticsearchContainer


internal object ElasticsearchContainerSingleton {
    val instance: ElasticsearchContainer by lazy { startElasticsearchContainer() }

    private fun startElasticsearchContainer(): ElasticsearchContainer =
        ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.10.0")
            .apply { start() }
}
