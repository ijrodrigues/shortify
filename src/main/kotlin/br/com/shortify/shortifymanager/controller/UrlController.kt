package br.com.shortify.shortifymanager.controller

import br.com.shortify.shortifymanager.dto.shortify.ShortifyRequest
import br.com.shortify.shortifymanager.dto.shortify.ShortifyResponse
import br.com.shortify.shortifymanager.service.UrlService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/shortify-manager")
class UrlController(private val urlService: UrlService) {

    @CrossOrigin
    @PostMapping("/shortify")
    @ResponseStatus(CREATED)
    fun shortify(@RequestBody shortifyRequest : ShortifyRequest): ShortifyResponse {
        val url = urlService.shortify(shortifyRequest.url, shortifyRequest.sanitizedId())
        return ShortifyResponse(url.id, url.originalUrl)
    }

    @GetMapping("/{id}")
    fun getUrlFromId(@PathVariable("id") id: String): ShortifyResponse {
        val url = urlService.findById(id)
        return ShortifyResponse(url.id, url.originalUrl)
    }
}
