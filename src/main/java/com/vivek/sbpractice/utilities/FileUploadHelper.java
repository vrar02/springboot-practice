package com.vivek.sbpractice.utilities;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class FileUploadHelper {

    public boolean uploadFile(MultipartFile file, String UPLOAD_DIR) throws IOException {
        boolean f=false;

        try{
            byte[] bytes1 = file.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + file.getOriginalFilename());
            fileOutputStream.write(bytes1);
            fileOutputStream.flush();
            fileOutputStream.close();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
