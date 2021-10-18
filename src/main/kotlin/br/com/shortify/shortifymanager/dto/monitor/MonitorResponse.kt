package br.com.shortify.shortifymanager.dto.monitor

data class MonitorResponse(
    val keys : Long,
    val usedKeys : Long,
    val availableKeys : Long
)
