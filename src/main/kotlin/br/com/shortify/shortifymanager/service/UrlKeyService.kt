package br.com.shortify.shortifymanager.service

import br.com.shortify.shortifymanager.domain.UrlKey
import br.com.shortify.shortifymanager.repository.UrlKeyRepository
import org.springframework.stereotype.Service

@Service
class UrlKeyService(private val urlKeyRepository: UrlKeyRepository) {

    fun getKey(): UrlKey {
        //todo: throw a specific exception
        return urlKeyRepository.findFirstByAvailableIsTrue().orElseThrow()
    }

    fun findById(id : String) = urlKeyRepository.findById(id)

    fun createCustomKey(id : String): UrlKey {
        //todo throw a especific exception
        findById(id).ifPresent { throw RuntimeException("$id Already exists!") }
        return urlKeyRepository.save(UrlKey(id, available = false, customId = true))
    }

    fun burnKey(urlKey : UrlKey) {
        urlKeyRepository.save(urlKey.copy(available = false))
    }
}
