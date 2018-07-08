package com.imooc.o2o.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest {

	@Autowired
	private ShopService shopService;

	@Test
	public void testModifyShop() throws Exception {
		Shop shop = new Shop();
		shop.setShopId(27L);
		shop.setShopName("修改了店铺名称");
		File shopImg = new File("D:/xiaohuangren.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution shopExecution = shopService.modifyShop(shop, is, "xiaohuangren.jpg");
		System.out.println(shopExecution.getShop().getShopImg());
	}

	@Test
	public void testAddShop() throws Exception {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();

		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);

		shop.setShopName("mytest2");
		shop.setShopDesc("mytest2");
		shop.setShopAddr("testaddr2");
		shop.setPhone("1111111121");
		shop.setShopImg("test2");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");

		File shopImg = new File("D:/mayun.jpg");

		// ShopExecution se = shopService.addShop(shop, shopImg);
		InputStream is = new FileInputStream(shopImg);
		ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
		System.out.println(ShopStateEnum.CHECK.getState());
		System.out.println(se.getState());
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}

}
