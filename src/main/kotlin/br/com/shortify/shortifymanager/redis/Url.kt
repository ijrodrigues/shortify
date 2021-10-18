package br.com.shortify.shortifymanager.redis

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "url")
data class Url(
    val originalUrl : String,
    @Id
    val id: String
)
