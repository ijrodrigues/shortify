package br.com.shortify.shortifymanager.domain

import org.hibernate.validator.constraints.URL
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Url(
    @URL
    val originalUrl : String,
    @Id
    val id: String
)
