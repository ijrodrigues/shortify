package br.com.shortify.shortifymanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShortifyManagerApplication

fun main(args: Array<String>) {
    runApplication<ShortifyManagerApplication>(*args)
}
