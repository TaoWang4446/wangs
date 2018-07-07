package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImgUtil {
	private static Logger logger = LoggerFactory.getLogger(ImgUtil.class);
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random random = new Random();
	
	/**
	 * 将 CommonsMultipartFile 转换为 File
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultiPartFileToFile(CommonsMultipartFile cFile){
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return newFile;
	}
	
	/**
	 * 处理 缩略图 并 返回 新生成图像的 相对路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(InputStream thumbnailInputStream, String targetAddr, String fileName) {
//  public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		
		String realFileName = getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr: "+relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("current destAddr: "+dest.toString());
		try{
			Thumbnails.of(thumbnailInputStream).size(400, 600)
//		    Thumbnails.of(thumbnail.getInputStream()).size(400, 600)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.35f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return relativeAddr;
	}

	/**
	 * 创建目标路径所涉及到的目录,即:D:/projectdev/image/xx.jpg
	 * 那么这三个 D:/projectdev/image/ 是要创建的
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取输入文件的扩展名
	 * @return
	 */
//	private static String getFileExtension(CommonsMultipartFile thumbnail) {
	private static String getFileExtension(String fileName) {
//		String originalFileName = thumbnail.getOriginalFilename();
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名 当前年月日小时分钟秒钟+5位随机数
	 * @return
	 */
	public static String getRandomFileName() {
		//获取随机的5位数
		int rannum = random.nextInt(8999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		
		return nowTimeStr + rannum;
	}

	public static void main(String[] args) throws IOException {
		Thumbnails.of(new File("D:/mayun.jpg")).size(400, 600)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.35f)
				.outputQuality(0.8f).toFile("D:/mayunnew.jpg");
	}

}
