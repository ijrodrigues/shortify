package br.com.shortify.shortifymanager.service

import br.com.shortify.shortifymanager.domain.Url
import br.com.shortify.shortifymanager.repository.UrlRedisRepository
import br.com.shortify.shortifymanager.repository.UrlRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class UrlService(
    private val urlRepository: UrlRepository,
    private val urlKeyService: UrlKeyService,
    private val urlRedisRepository: UrlRedisRepository
) {

    @Transactional
    fun shortify(value: String, sanitizedId: String?): Url {
        if(sanitizedId.isNullOrBlank()){
            return shortifyWithGeneratedId(value)
        }
        return shortifyWithCustomId(value, sanitizedId)
    }

    private fun shortifyWithCustomId(value: String, sanitizedId: String): Url {
        val urlKey = urlKeyService.createCustomKey(sanitizedId)
        val url = urlRepository.save(Url(value, urlKey.id))
        urlRedisRepository.save(br.com.shortify.shortifymanager.redis.Url(value, urlKey.id))
        return url
    }

    private fun shortifyWithGeneratedId(value: String): Url {
        val urlKey = urlKeyService.getKey()
        val url = urlRepository.save(Url(value, urlKey.id))
        urlKeyService.burnKey(urlKey)
        urlRedisRepository.save(br.com.shortify.shortifymanager.redis.Url(value, urlKey.id))
        return url
    }

    fun findById(id : String): Url {
        //todo: throw a specific exception
        return urlRepository.findById(id).orElseThrow { RuntimeException("Id $id does not exists") }
    }
}
