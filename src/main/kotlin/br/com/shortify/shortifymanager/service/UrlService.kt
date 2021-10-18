package br.com.shortify.shortifymanager.service

import br.com.shortify.shortifymanager.domain.Url
import br.com.shortify.shortifymanager.repository.UrlRedisRepository
import br.com.shortify.shortifymanager.repository.UrlRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UrlService(
    private val urlRepository: UrlRepository,
    private val urlKeyService: UrlKeyService,
    private val urlRedisRepository: UrlRedisRepository
) {

    @Transactional
    fun shortify(value : String): Url {
        val urlKey = urlKeyService.getKey()
        val url = urlRepository.save(Url(value, urlKey.id))
        urlKeyService.burnKey(urlKey)
        urlRedisRepository.save(br.com.shortify.shortifymanager.redis.Url(value, urlKey.id))
        return url
    }

    fun findById(id : String): Url {
        //todo: throw a specific exception
        return urlRepository.findById(id).orElseThrow()
    }
}
