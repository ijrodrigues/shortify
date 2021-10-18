package br.com.shortify.shortifymanager.dto.shortify

data class ShortifyRequest(
    //todo: validate field, check if value it's a url
    val url : String
)
