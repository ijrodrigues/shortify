package br.com.shortify.shortifymanager.repository

import br.com.shortify.shortifymanager.domain.UrlKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UrlKeyRepository : JpaRepository<UrlKey, String> {
    fun findFirstByAvailableIsTrue(): Optional<UrlKey>
    fun countByAvailableIsTrue(): Long
}
