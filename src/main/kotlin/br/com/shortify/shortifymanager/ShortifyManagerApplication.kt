package br.com.shortify.shortifymanager

import br.com.shortify.shortifymanager.domain.UrlKey
import br.com.shortify.shortifymanager.repository.UrlKeyRepository
import org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

const val LENGTH = 5

@SpringBootApplication
class ShortifyManagerApplication : CommandLineRunner {

    @Autowired
    lateinit var urlKeyRepository : UrlKeyRepository

    val logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        val shouldGenerateSomeKeys = false

        if(shouldGenerateSomeKeys){
            logger.info("Creating new url keys")
            val keys = mutableSetOf<String>()

            for (x in 0..1000){
                keys.add(randomAlphanumeric(LENGTH).lowercase())
            }

            logger.info("${keys.size} Generated keys = $keys")
            urlKeyRepository.saveAll(keys.map { UrlKey(it) })
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ShortifyManagerApplication>(*args)
}
