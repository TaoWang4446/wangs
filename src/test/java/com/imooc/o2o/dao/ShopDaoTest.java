package com.imooc.o2o.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopList() throws Exception {
		Shop shop = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shop.setShopCategory(sc);
		
		List<Shop> shopList = shopDao.queryShopList(shop, 1, 2);
		int count = shopDao.queryShopCount(shop);
		System.out.println(count);
		System.out.println(shopList.get(1).getShopName());
	}
	
	@Test
	public void testQueryShopListAndCount() throws Exception {
		Shop shop = new Shop();
		List<Shop> shopList = shopDao.queryShopList(shop, 0, 2);
		assertEquals(2, shopList.size());
		int count = shopDao.queryShopCount(shop);
		assertEquals(5, count);
		shop.setShopName("名称");
		shopList = shopDao.queryShopList(shop, 0, 3);
		assertEquals(2, shopList.size());
		count = shopDao.queryShopCount(shop);
		assertEquals(2, count);
		shop.setShopId(25L);
		shopList = shopDao.queryShopList(shop, 0, 3);
		assertEquals(1, shopList.size());
		count = shopDao.queryShopCount(shop);
		assertEquals(1, count);

	}

	@Test
	public void testQueryByShopId() {
		long shopId = 25L;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println(shop.getArea().getAreaName());
	}
	
	@Test
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		ShopCategory shopCategory = new ShopCategory();
		Area area = new Area();
		
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("646464646");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1,effectedNum);
	}

	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		
		shop.setShopId(1L);
		shop.setShopName("测试的店铺1");
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1,effectedNum);
	}
}
