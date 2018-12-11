package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//专门处理文件，返回对应的json数据
@Controller
@RequestMapping("/pic")
public class PicController {

    //先不考虑回显，url从common.js中来看是对应一个图片的
    @ResponseBody
    @RequestMapping(value = "/upload")
    public Map uploadProductPic(String dir, MultipartFile uploadFile, HttpSession session) throws IOException {
        String realPath = session.getServletContext().getRealPath("/pic/");
        String originalFilename = uploadFile.getOriginalFilename();
        String fileUploadPath=realPath+originalFilename;
        uploadFile.transferTo(new File(fileUploadPath));
        Map<String, Object> map=new HashMap<>();
        map.put("error", 0);
        map.put("url", ("/pic/"+originalFilename));
        return map;
    }

    //删除图片
    @ResponseBody
    @RequestMapping("/delete")
    public Map deletePic(String picName, HttpSession session){
        Map<String, Object> map=new HashMap<>();
        String realPath = session.getServletContext().getRealPath(picName);
        File file=new File(realPath);
        boolean delete = file.delete();
        if(delete){
            map.put("data", "success");
        }else{
            map.put("message", "文件上传失败");
        }
        return map;
    }
}
