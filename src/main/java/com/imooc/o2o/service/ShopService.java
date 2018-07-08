package com.imooc.o2o.service;

import java.io.InputStream;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;

public interface ShopService {

	/**
	 * 通过shopId 获取 shop信息
	 * 
	 * @param ShopId
	 * @return
	 * @throws ShopOperationException
	 */
	Shop getByShopId(long shopId) throws ShopOperationException;

	/**
	 * 更新shop信息 包括对图片的处理
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

	/**
	 * 添加店铺
	 * 
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
