package com.bitcamp.team_project_eco.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class UploadController {

    //커버이미지 업로드
    @ResponseBody
    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String uploadAjaxCoverImg(MultipartFile file) throws Exception {

        String uploadpath = "homeBanner";

        ResponseEntity<String> img_path = new ResponseEntity<>(
                UploadFileUtils.uploadFile(uploadpath, file.getOriginalFilename(), file.getBytes()),
                HttpStatus.CREATED);

        return (String) img_path.getBody();
    }

    @ResponseBody
    @RequestMapping(value = "/postImgUpload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String uploadPostImg(MultipartFile file) throws Exception {
        String uploadpath = "postImage";

        ResponseEntity<String> img_path = new ResponseEntity<>(
                UploadFileUtils.postUploadFile(uploadpath, file.getOriginalFilename(), file.getBytes()),
                HttpStatus.CREATED);
        return (String) img_path.getBody();
    }

    @ResponseBody
    @RequestMapping(value = "/profileUpload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String uploadProfileImg(MultipartFile file) throws Exception {
        String uploadpath = "profileImg";

        ResponseEntity<String> img_path = new ResponseEntity<>(
                UploadFileUtils.profileUploadFile(uploadpath, file.getOriginalFilename(), file.getBytes()),
                HttpStatus.CREATED);
        return (String) img_path.getBody();
    }



}