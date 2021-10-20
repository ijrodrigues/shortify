package br.com.shortify.shortifymanager.config.seed

import br.com.shortify.shortifymanager.domain.UrlKey
import br.com.shortify.shortifymanager.repository.UrlKeyRepository
import org.apache.commons.lang3.RandomStringUtils
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

const val LENGTH = 5

@Component
class KeySeedGenerator(
    val urlKeyRepository: UrlKeyRepository,
    @Value("\${keys-to-generate-at-start}") val urlKeysGeneratedAtStart: Long
) : CommandLineRunner {

    val logger = getLogger(javaClass)

    override fun run(vararg args: String?) {
            logger.info("Creating new url keys")
            val keys = mutableSetOf<String>()

            for (x in 1..urlKeysGeneratedAtStart) {
                keys.add(RandomStringUtils.randomAlphanumeric(LENGTH).lowercase())
            }

            logger.info("${keys.size} Generated keys = $keys")
            urlKeyRepository.saveAll(keys.map { UrlKey(it) })
    }
}
