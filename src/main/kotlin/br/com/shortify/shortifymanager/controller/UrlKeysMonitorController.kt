package br.com.shortify.shortifymanager.controller

import br.com.shortify.shortifymanager.dto.monitor.MonitorResponse
import br.com.shortify.shortifymanager.repository.UrlKeyRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/monitor")
class UrlKeysMonitorController(private val urlKeyRepository: UrlKeyRepository) {

    @GetMapping
    fun monitor(): MonitorResponse {
        val availableKeysCount = urlKeyRepository.countByAvailableIsTrue()
        val allKeysCount = urlKeyRepository.count()
        return MonitorResponse(allKeysCount, allKeysCount - availableKeysCount, availableKeysCount)
    }
}
