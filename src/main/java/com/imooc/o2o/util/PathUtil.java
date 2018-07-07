package com.imooc.o2o.util;

public class PathUtil {

	private static String separator = System.getProperty("file.separator");

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image/";
		} else {
			basePath = "/home/xiangze/image/";
		}
		basePath = basePath.replace("/", separator);

		return basePath;
	}

	public static String getShopImgPath(long shopId) {
	
		String imagePath = "upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", separator);
	}
	
	/*public static void main(String[] args) {
		System.out.println(separator);
	}*/
}