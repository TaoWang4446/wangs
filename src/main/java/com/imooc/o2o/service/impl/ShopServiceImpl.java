package com.imooc.o2o.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImgUtil;
import com.imooc.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional
//	public ShopExecution addShop(Shop shop, File shopImg) {
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
		//控制判断
		if(null == shop){
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		
		try{
			//给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			
			//添加店铺信息
			int effectNum = shopDao.insertShop(shop);
			if(effectNum <= 0){
				throw new ShopOperationException("店铺创建失败");
			}else{
				if(shopImgInputStream != null){
					//存储图片
					try{
						addShopImg(shop, shopImgInputStream,fileName);
					}catch(Exception e){
						throw new ShopOperationException("add shopImg error:" + e.getMessage());
					}
					
					//更新店铺的图片地址
					effectNum = shopDao.updateShop(shop);
					if(effectNum <= 0){
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
			
		}catch(Exception e){
			throw new ShopOperationException("add shop error:"+e.getMessage());
		}
		
		return new ShopExecution(ShopStateEnum.CHECK);
	}

	private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
		//获取shop图片目录 的 相对路径
		String dest = PathUtil.getShopImgPath(shop.getShopId());
		String shopImgAddr = ImgUtil.generateThumbnail(shopImgInputStream, dest, fileName);
		shop.setShopImg(shopImgAddr);
	}

}
