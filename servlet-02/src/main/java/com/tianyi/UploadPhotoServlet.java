package com.tianyi;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class UploadPhotoServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为1m
            factory.setSizeThreshold(1024 * 1024);
            List items = null;
            try {
                items = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    //根据时间戳创建文件头像
                    filename = System.currentTimeMillis() + ".jpg";
                    String photoFolder = req.getSession().getServletContext().getRealPath("uploaded");
                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();

                    //通过item.getInputStream()获取浏览器上传文件的输入流
                    InputStream is = null;
                    try {
                        is = item.getInputStream();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        FileOutputStream fos = new FileOutputStream(f);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    //复制文件
                    byte[] b = new byte[1024 * 1024];
                    FileOutputStream fos = new FileOutputStream(f);
                    int len = 0;
                    while (-1 != (len = is.read(b))) {
                        fos.write(b, 0, len);
                    }
                    fos.close();
                } else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "utf-8");
                    System.out.println(value);
                }
            }
            String html = "<img width='200' height='150' src='uploaded/%s' />";
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.format(html, filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
