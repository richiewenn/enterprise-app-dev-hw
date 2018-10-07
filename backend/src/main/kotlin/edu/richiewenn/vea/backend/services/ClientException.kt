package edu.richiewenn.vea.backend.services

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class ClientException(override val message: String?): RuntimeException(message) {
}