package com.imooc.o2o.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
		//assertEquals(1,shopCategoryList.size());
		
		ShopCategory shopCategory = new ShopCategory();
		ShopCategory shopCategoryParent = new ShopCategory();
		shopCategoryParent.setShopCategoryId(1L);
		shopCategory.setParent(shopCategoryParent);
		List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(shopCategory);
		assertEquals(1,shopCategoryList1.size());
	}

}
