package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {
	
	/**
	 * 根据店铺id查询 shop信息
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);
	
	/**
	 * 新增店铺
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);
	/**
	 * 店铺修改
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
