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

    @ResponseBody
    @RequestMapping("/upload")
    public Map uploadProductPic(String dir, MultipartFile[] uploadFile, HttpSession session) throws IOException {
        String realPath = session.getServletContext().getRealPath("/pic/");
        StringBuilder sb=new StringBuilder();
        for (MultipartFile file: uploadFile) {
            String originalFilename = file.getOriginalFilename();
            String fileUploadPath=realPath+originalFilename;
            file.transferTo(new File(fileUploadPath));
            sb.append("/pic/"+originalFilename+",");
        }
        Map<String, Object> map=new HashMap<>();
        map.put("pics", sb.toString());
        map.put("url", sb.toString());
        return map;
    }
}
