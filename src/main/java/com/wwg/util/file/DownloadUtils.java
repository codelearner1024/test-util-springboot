package com.wwg.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/** 
 * 文件下载类 
 */
public class DownloadUtils {

  private final static Logger logger = Logger.getLogger(DownloadUtils.class);

  /** 
   * 文件下载编码 
   * 该编码告诉浏览器文件名的编码方式，以防下载中文文件名时有乱码 
   */
  private static String encoding = "utf-8"; 

  private DownloadUtils(){}

  /** 
   * 文件下载 
   * @param response 
   * @param filePath 文件在服务器上的路径，包含文件名 
   */
  public static void download(HttpServletRequest request,HttpServletResponse response, String filePath){ 
    File file = new File(filePath.toString()); 
    download(request,response, file, null, encoding); 
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param filePath 文件在服务器上的路径，包括文件名称 
   * @param fileName 文件下载到浏览器的名称，如果不想让浏览器下载的文件名称和服务器上的文件名称一样，请设置该参数 
   */
  public static void download(HttpServletRequest request,HttpServletResponse response, String filePath, String fileName){ 
    File file = new File(filePath.toString()); 
    download(request,response, file, fileName, encoding); 
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param filePath 文件在服务器上的路径，包括文件名称 
   * @param fileName 文件下载到浏览器的名称，如果不想让浏览器下载的文件名称和服务器上的文件名称一样，请设置该参数 
   * @param encoding 文件名称编码 
   */
  public static void download(HttpServletRequest request,HttpServletResponse response, String filePath, String fileName, String encoding){ 
    File file = new File(filePath.toString()); 
    download(request,response, file, fileName, encoding); 
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param file 文件 
   * @param fileName 文件下载到浏览器的名称，如果不想让浏览器下载的文件名称和服务器上的文件名称一样，请设置该参数 
   */
  public static void download(HttpServletRequest request,HttpServletResponse response, File file) { 
    download(request,response, file, null, encoding); 
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param file 文件 
   * @param fileName 文件下载到浏览器的名称，如果不想让浏览器下载的文件名称和服务器上的文件名称一样，请设置该参数 
   */
  public static void download(HttpServletRequest request,HttpServletResponse response, File file, String fileName) { 
    download(request,response, file, fileName, encoding); 
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param file 文件 
   * @param fileName 文件下载到浏览器的名称，如果不想让浏览器下载的文件名称和服务器上的文件名称一样，请设置该参数 
   * @param encoding 文件名称编码 
   */
  public static void download(HttpServletRequest request, HttpServletResponse response, File file, String fileName, String encoding) {
    if (file == null || !file.exists() || file.isDirectory()) {
      return;
    }

    // 如果不指定文件下载到浏览器的名称，则使用文件的默认名称 
    if (StringUtils.isBlank(fileName)) {
      fileName = file.getName();
    }

    try {
      InputStream is = new FileInputStream(file);
      download(request, response, is, fileName, encoding);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param is 文件输入流 
   * @param fileName 下载的文件名称 
   * @throws IOException 
   */
  public static void download(HttpServletRequest request,HttpServletResponse response, InputStream is, String fileName){ 
    download(request,response, is, fileName, encoding); 
  } 
    
  /** 
   * 文件下载 
   * @param response 
   * @param is 文件输入流 
   * @param fileName 下载的文件名称 
   * @param encoding 编码格式 
   */
  public static void download(HttpServletRequest request, HttpServletResponse response, InputStream is, String fileName, String encoding) {
    if (is == null || StringUtils.isBlank(fileName)) {
      return;
    }
    try (
            BufferedInputStream bis = new BufferedInputStream(is);
            OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
    ) {

      response.setContentType("application/octet-stream;charset=" + encoding);
      response.setCharacterEncoding(encoding);
      String userAgent = request.getHeader("User-Agent");
      // byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题

      if(isChromeSafariFireFox(userAgent.toLowerCase())){
        //非IE浏览器的处理：
        fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
      } else {
        fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
      }

      //   fileName = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码
      response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName));
      byte[] buffer = new byte[1024];
      int len = bis.read(buffer);
      while (len != -1) {
        bos.write(buffer, 0, len);
        len = bis.read(buffer);
      }

      bos.flush();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  } 
  
  public static String getEncoding() { 
    return encoding; 
  } 
  
  public static void setEncoding(String encoding) { 
    DownloadUtils.encoding = encoding; 
  }


  public static boolean isChromeSafariFireFox(String userAgent) {
    if (StringUtils.isEmpty(userAgent)) {
      return false;
    }

    if (userAgent.contains("chrome") || userAgent.contains("safari") || userAgent.contains("firefox")) {
      return true;
    }
    return false;
  }
} 