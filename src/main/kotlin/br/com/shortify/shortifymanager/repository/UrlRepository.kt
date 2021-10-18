package br.com.shortify.shortifymanager.repository

import br.com.shortify.shortifymanager.domain.Url
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : JpaRepository<Url, String>
