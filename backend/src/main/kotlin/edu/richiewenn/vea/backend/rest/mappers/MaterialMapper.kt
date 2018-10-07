package edu.richiewenn.vea.backend.rest.mappers

import edu.richiewenn.vea.api.rest.dtos.MaterialDTO
import edu.richiewenn.vea.api.rest.dtos.MaterialSaleDTO
import edu.richiewenn.vea.api.rest.dtos.MaterialStockDTO
import edu.richiewenn.vea.backend.models.Material
import edu.richiewenn.vea.backend.models.MaterialSale
import edu.richiewenn.vea.backend.models.MaterialStock

object MaterialMapper {
  fun map(source: Material) = MaterialDTO(
    id = source.id,
    name = source.name
  )

  fun map(source: MaterialDTO) = Material(
    id = source.id,
    name = source.name
  )

  fun map(source: MaterialStock) = MaterialStockDTO(
    id = source.id,
    material = map(source.material),
    stock = source.stock
  )

  fun map(source: MaterialStockDTO) = MaterialStock(
    id = source.id,
    material = map(source.material),
    stock = source.stock
  )

  fun map(source: MaterialSale) = MaterialSaleDTO(
    id = source.id,
    amount = source.amount,
    sold = source.sold,
    material = MaterialMapper.map(source.material)
  )

  fun map(source: MaterialSaleDTO) = MaterialSale(
    id = source.id,
    amount = source.amount,
    sold = source.sold,
    material = MaterialMapper.map(source.material)
  )
}