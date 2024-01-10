package com.springboot.internship.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class fileController {
    @PostMapping("/upload")
    public boolean upload(@RequestParam("file") MultipartFile file, @RequestParam("filename") String filename, @RequestParam("folder") String folder) {
        System.out.println("upload进入");
        String filePath = "D:\\IDEA项目\\internship-back-end-master\\fileBase\\" + folder + "\\";
        File dest = new File(filePath + filename);
        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    @GetMapping("/avatar")
    public void getavatar(@RequestParam("path") String path, HttpServletResponse response) {
        System.out.println("jing ru avatar");
        System.out.println(path);
        String prepath = "D:\\IDEA项目\\internship-back-end-master\\fileBase\\avatar";
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        try{
            fileInputStream = new FileInputStream(prepath + "\\" + path);
            outputStream = response.getOutputStream();
            FileCopyUtils.copy(fileInputStream,outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/CV")
    public void getCV(@RequestParam("path") String path,HttpServletResponse response){
        System.out.println("jing ru cv");
        System.out.println(path);
        String prepath = "D:\\IDEA项目\\internship-back-end-master\\fileBase\\CV";
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        try{
            fileInputStream = new FileInputStream(prepath + "\\" +path);
            outputStream = response.getOutputStream();
            FileCopyUtils.copy(fileInputStream,outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
