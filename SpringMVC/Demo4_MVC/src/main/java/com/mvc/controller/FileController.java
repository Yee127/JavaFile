package com.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    private static final Log logger = LogFactory.getLog(FileController.class);

    /**
     * 单文件上传
     * @param d  描述
     * @param myfile  文件
     * @return
     */
    @RequestMapping("/upload")
    public String upload(String d, MultipartFile myfile){
        String fileName = myfile.getOriginalFilename();
        System.out.println(d);
        System.out.println(fileName);
        String path = "/Users/yee/IdeaProjects/SpringMVC/Demo4_MVC/web/uploadfiles/"+fileName;
        File file = new File(path);
        try {
            myfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "showFile";
    }

    @RequestMapping("/upload1")
    public String upload1(String desc, MultipartFile[] file){

        for(MultipartFile multipartFile:file){
            String fileName = multipartFile.getOriginalFilename();
            System.out.println(desc);
            System.out.println(fileName);
            String path = "/Users/yee/IdeaProjects/SpringMVC/Demo4_MVC/web/uploadfiles/"+fileName;
            File uploadfile = new File(path);
            try {
                multipartFile.transferTo(uploadfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "showFile";
    }

    @RequestMapping("/uploadFile")
    public String sub()
    {
        return "uploadFile";
    }
}
