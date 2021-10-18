package br.com.shortify.shortifymanager.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UrlKey(
    @Id
    val id: String,
    val available: Boolean = true,
    val customId: Boolean = false
)
