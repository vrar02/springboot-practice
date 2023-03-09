package com.vivek.sbpractice.controllers;

import com.vivek.sbpractice.utilities.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Controller
public class TestController{

    @Autowired
    FileUploadHelper fileUploadHelper;
    //use ResponseBody annotation to simply send string as the output...
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testApi(){
        return "test";
    }


    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @PostMapping("/fileUpload")
    public Object fileUpload(@RequestParam("fileInfo")String fileInfo,
                             @RequestParam("actualFile")MultipartFile multipartFile,
                             Model model){


        try {
            String UPLOAD_DIR="D:\\my_files\\";
            fileUploadHelper.uploadFile(multipartFile,UPLOAD_DIR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("failed to upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        model.addAttribute("msg","File upload successfully");
        model.addAttribute("file_info",fileInfo);
        return "success";
    }

    @PostMapping("/imageUpload")
    public Object imageUpload(@RequestParam("img")MultipartFile image, Model model){

        try {
            System.out.println(new ClassPathResource("").getFile().getAbsolutePath());
            String upload_dir=new ClassPathResource("/static/image").getFile().getAbsolutePath()+"\\";
            System.out.println(upload_dir);

            fileUploadHelper.uploadFile(image,upload_dir);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("failed to upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String url= ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                .path(image.getOriginalFilename()).toUriString();

        model.addAttribute("msg","Image upload successfully..available at "+url);
        return "success";
    }


}
