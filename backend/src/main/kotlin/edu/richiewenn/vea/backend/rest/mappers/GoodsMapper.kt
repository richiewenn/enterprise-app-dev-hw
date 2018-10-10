package edu.richiewenn.vea.backend.rest.mappers

import edu.richiewenn.vea.api.rest.dtos.GoodsDTO
import edu.richiewenn.vea.api.rest.dtos.GoodsSaleDTO
import edu.richiewenn.vea.api.rest.dtos.GoodsStockDTO
import edu.richiewenn.vea.backend.models.Goods
import edu.richiewenn.vea.backend.models.GoodsSale
import edu.richiewenn.vea.backend.models.GoodsStock

object GoodsMapper {
  fun map(source: Goods) = GoodsDTO(
    id = source.id,
    name = source.name,
    requiredMaterials = source.requiredMaterials
  )

  fun map(source: GoodsDTO) = Goods(
    id = source.id,
    name = source.name,
    requiredMaterials = source.requiredMaterials
  )

  fun map(source: GoodsStock) = GoodsStockDTO(
//    id = source.id,
    stock = source.stock,
    goods = GoodsMapper.map(source.goods)
  )

  fun map(source: GoodsStockDTO) = GoodsStock(
//    id = source.id,
    stock = source.stock,
    goods = GoodsMapper.map(source.goods)
  )

  fun map(source: GoodsSale) = GoodsSaleDTO(
    id = source.id,
    amount = source.amount,
    goods = GoodsMapper.map(source.goods),
    materialSales = source.materialSales.map(MaterialMapper::map),
    sold = source.sold
  )

  fun map(source: GoodsSaleDTO) = GoodsSale(
    id = source.id,
    amount = source.amount,
    goods = GoodsMapper.map(source.goods),
    materialSales = source.materialSales.map(MaterialMapper::map),
    sold = source.sold
  )
}