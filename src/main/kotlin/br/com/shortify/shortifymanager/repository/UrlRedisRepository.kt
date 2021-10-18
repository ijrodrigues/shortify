package br.com.shortify.shortifymanager.repository

import br.com.shortify.shortifymanager.redis.Url
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRedisRepository : CrudRepository<Url, String>
