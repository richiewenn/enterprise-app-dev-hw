package edu.richiewenn.vea.ex4.rest.dtos

data class JsonResponse<T>(
  val data: T? = null,
  val error: JsonError? = null
)

data class JsonError(
  val statusCode: Int = 500,
  val message: String
)