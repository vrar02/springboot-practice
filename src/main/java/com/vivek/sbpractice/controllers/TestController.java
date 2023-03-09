package com.vivek.sbpractice.controllers;

import com.vivek.sbpractice.utilities.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            fileUploadHelper.uploadFile(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("failed to upload", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        model.addAttribute("msg","File upload successfully");
        model.addAttribute("file_info",fileInfo);
        return "success";
    }
}
