package br.com.shortify.shortifymanager.dto.shortify

data class ShortifyRequest(
    //todo: validate field, check if value it's a url
    val url: String,
    val id: String?
) {
    fun sanitizedId() =
        id?.let { value -> value.filter { it.isLetterOrDigit() || it.isWhitespace() } }
            ?.replace("\\s".toRegex(), "-")
            ?.lowercase()
}
