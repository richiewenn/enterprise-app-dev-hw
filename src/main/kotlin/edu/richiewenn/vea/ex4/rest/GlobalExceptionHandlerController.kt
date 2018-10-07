package edu.richiewenn.vea.ex4.rest

import edu.richiewenn.vea.ex4.rest.dtos.JsonError
import edu.richiewenn.vea.ex4.rest.dtos.JsonResponse
import edu.richiewenn.vea.ex4.services.ClientException
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.logging.Logger


@ControllerAdvice
class GlobalExceptionHandlerController: ResponseEntityExceptionHandler() {

  @ExceptionHandler
  protected fun handleConflict(ex: RuntimeException, request: WebRequest): ResponseEntity<Any> {
    val statusCode: Int = if(ex is ClientException) 400 else 500
    val error = JsonError(
      message = ex.localizedMessage,
      statusCode = statusCode
    )
    val bodyOfResponse = JsonResponse<Nothing>(error = error)
    this.logger.error(ex)
    return handleExceptionInternal(ex, bodyOfResponse,
      HttpHeaders(), HttpStatus.CONFLICT, request)
  }
}