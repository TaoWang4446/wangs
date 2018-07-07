package com.imooc.o2o.util;
/**
 * @Date: 2013-6-18
 * @Author: jilongliang
 * @Description：System.getProperty详解
 */
@SuppressWarnings("all")
public class SysProperty {
	public static void main(String[] args) {
		System.out.println(classVersion());
	}
	/**获取操作系统名称*/
	private static String osName() {
		return System.getProperty("os.name");
	}
	/**获取操作系统版本*/
	private static String osVersion() {
		return System.getProperty("os.version");
	}
	/**获取Java运行时环境供应商*/
	private static String vendor() {
		return System.getProperty("java.vendor");
	}
	/**获取Java供应商的 URL*/
	private static String vendorUrl() {
		return System.getProperty("java.vendor.url");
	}
	/**Java 安装目录*/
	private static String home() {
		return System.getProperty("java.home");
	}
	/**获取类的版本*/
	private static String classVersion() {
		return System.getProperty("java.class.version");
	}
	/**
	 * Java 类路径
	 * @return
	 */
	private static String classPath() {
		return System.getProperty("java.class.path");
	}
	/**
	 * 操作系统的架构
	 * @return
	 */
	private static String osArch() {

		return System.getProperty("os.arch");
	}
	/**
	 * 获取用户的账户名称
	 * @return
	 */
	private static String userName() {
		return System.getProperty("user.name");
	}
	/**
	 * 获取用户的主目录
	 * @return
	 */
	private static String userHome() {
		return System.getProperty("user.home");
	}
	/**
	 * 用户的当前工作目录
	 * @return
	 */
	private static String userDir() {
		return System.getProperty("user.dir");
	}
	/**
	 * Java 虚拟机规范版本
	 * @return
	 */
	private static String vmSpecificationVersion() {
		return System.getProperty("java.vm.specification.version");
	}
	/**
	 * Java 虚拟机规范供应商
	 * @return
	 */
	private static String vmSpecificationVendor() {
		return System.getProperty("java.vm.specification.vendor");
	}
	/**
	 * Java 虚拟机规范名称
	 * @return
	 */
	private static String vmSpecificationName() {
		return System.getProperty("java.vm.specification.name");
	}
	/**
	 * Java 虚拟机实现版本
	 * @return
	 */
	private static String vmVersion() {
		return System.getProperty("java.vm.version");
	}
	/**
	 * Java 虚拟机实现供应商
	 * @return
	 */
	private static String vmVendor() {
		return System.getProperty("java.vm.vendor");
	}
	/**
	 * Java 虚拟机实现名称
	 * @return
	 */
	private static String vmName() {
		return System.getProperty("java.vm.name");
	}
	/**
	 * 一个或多个扩展目录的路径
	 * @return
	 */
	private static String extDirs() {
		return System.getProperty("java.ext.dirs");
	}	
	/**
	 *加载库时搜索的路径列表
	 * @return
	 */
	private static String library() {
		return System.getProperty("java.library.path");
	}
	/**
	 * 文件分隔符（在 UNIX 系统中是“/”）
	 * @return
	 */
	private static String fileSeparator() {
		return System.getProperty("file.separator");
	}
	/**
	 * 路径分隔符（在 UNIX 系统中是“:”）
	 * @return
	 */
	private static String pathSeparator() {
		return System.getProperty("path.separator");
	}
	/**
	 * 行分隔符（在 UNIX 系统中是“/n”）
	 * @return
	 */
	private static String lineSeparator() {
		return System.getProperty("line.separator");
	}
	/**
	 * 要使用的 JIT 编译器的名称
	 * @return
	 */
	private static String compiler() {
		return System.getProperty("java.compiler");
	}

	/**
	 * C:\Users\ADMINI~1\AppData\Local\Temp\ 获取当前临时目录
	 * 
	 * @return
	 */
	public static String getSystempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	/**
	 * 以\分割
	 * 
	 * @return
	 */
	public static String getSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * 如:file:/D:/Workspaces/MyEclipse%208.6/myapp/WebRoot/WEB-INF/classes/未处理
	 * 处理后：D:\Workspaces\MyEclipse%208.6\napp\WebRoot\ 获取当前项目的路径
	 * 
	 * @return
	 */
	public static String getSysPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		System.out.println(path);
		String temp = path.replaceFirst("file:/", "").replaceFirst("WEB-INF/classes/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	/**
	 * 未处理 D:/Workspaces/MyEclipse%208.6/myapp/WebRoot/WEB-INF/classes/ 已处理
	 * D:\Workspaces\MyEclipse%208.6\myapp\WebRoot\WEB-INF\classes\
	 * 
	 * @return
	 */
	public static String getClassPath() {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		String temp = path.replaceFirst("file:/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

}

