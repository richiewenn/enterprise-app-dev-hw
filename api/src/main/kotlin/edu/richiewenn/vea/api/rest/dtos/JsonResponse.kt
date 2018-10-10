package edu.richiewenn.vea.api.rest.dtos

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class JsonResponse<T>(
  val data: T? = null,
  val error: JsonError? = null
)

object JsonWrapper {
  fun <T>wrap(data: T): JsonResponse<T> = JsonResponse(
    data = data
  )
}

data class JsonError(
  val statusCode: Int = 500,
  val message: String
)