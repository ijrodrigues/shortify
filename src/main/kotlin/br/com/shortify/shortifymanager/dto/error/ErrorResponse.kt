package br.com.shortify.shortifymanager.dto.error

data class ErrorResponse(val error: ErrorMessageResponse)
data class ErrorMessageResponse(val message: String)
