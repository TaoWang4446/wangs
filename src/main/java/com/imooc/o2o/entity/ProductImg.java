package com.imooc.o2o.entity;

import java.util.Date;

public class ProductImg {
	// 商品图像id
	private Long productImgId;
	// 商品图像地址
	private String imgAddr;
	// 商品图像描述
	private String imgDesc;
	// 商品图像显示权重(优先级)
	private Integer priority;
	// 商品图像创建时间
	private Date createTime;
	// 商品id:属于哪个商品的图像
	private Long productId;

	public Long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
