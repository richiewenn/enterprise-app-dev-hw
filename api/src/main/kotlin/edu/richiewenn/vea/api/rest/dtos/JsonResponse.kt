package edu.richiewenn.vea.api.rest.dtos

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