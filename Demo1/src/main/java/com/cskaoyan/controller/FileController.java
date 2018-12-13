package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//处理文件上传
@Controller
@RequestMapping("/file")
public class FileController {


    //由common.js可知，文件是一个个处理的！","会在js中添加
    @ResponseBody
    @RequestMapping("/upload")
    public Map uploadFile(MultipartFile file, HttpSession session) throws IOException {
        String dirPath = session.getServletContext().getRealPath("file");
        StringBuilder sb=new StringBuilder();
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File(dirPath+"/"+originalFilename));
        sb.append("/file/"+originalFilename);
        Map<String, Object> map=new HashMap<>();
        map.put("error", 0);
        map.put("url", sb.toString());
        System.out.println(map);
        return map;
    }


    //成功，返回data:success，失败返回服务器返回的错误信息
    @ResponseBody
    @RequestMapping("/delete")
    public Map deleteFile(String fileName, HttpSession session){
        Map<String, Object> map=new HashMap<>();
        String realPath = session.getServletContext().getRealPath("");
        File file=new File(realPath+fileName);
        boolean delete = file.delete();
        if(delete){
            map.put("data", "success");
        }else{
            map.put("message", "文件上传失败");
        }
        return map;
    }

    //文件下载
    @RequestMapping("/download")
    public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realFileName=fileName.substring(fileName.lastIndexOf("/")+1);
        //解决乱码问题
        String downloadFileName = new String(realFileName.getBytes("UTF-8"),"iso-8859-1");
        //设置报文头
        //设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
        response.setHeader("Content-Disposition", "attachment;fileName="+downloadFileName);
        String realPath = request.getServletContext().getRealPath(fileName);
        File fileToDownload=new File(realPath);
        FileInputStream fileInputStream=new FileInputStream(fileToDownload);
        ServletOutputStream outputStream = response.getOutputStream();
        int len=0;
        byte[] bytes=new byte[1024];
        while((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
        outputStream.flush();
    }
}
