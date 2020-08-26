package com.bitcamp.team_project_eco.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadFileUtils {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
    private static final String contextPath = "https://teamev911.s3.ap-northeast-2.amazonaws.com"; // 앞에 버킷네임 teamev911 수정.
    private static final String bucketName = "teamev911"; //AWS S3 생성한 버킷네임.

    public static String uploadFile(String uploadPath, String originalName, byte[] byteData) throws Exception {
        S3Util s3 = new S3Util();
        //랜덤의 uid 를 만들어준다.
        UUID uid = UUID.randomUUID();

        //savedName : 570d570a-7af1-4afe-8ed5-391d660084b7_g.JPG 같은 형식으로 만들어준다.
        //String savedName = "/"+uid.toString() + "_" + originalName;
        String savedName = "/"+ originalName;

        logger.info("업로드 경로 : "+uploadPath);
        //\2017\12\27 같은 형태로 저장해준다.
        //String savedPath = calcPath(uploadPath);
        String savedPath = "";

        String uploadedFileName = (savedPath + savedName).replace(File.separatorChar, '/');

        //S3Util 의 fileUpload 메서드로 파일을 업로드한다.
        s3.fileUpload(bucketName, uploadPath+uploadedFileName, byteData);


        logger.info(uploadedFileName);
// s3.fileUpload(bucketName, new File(fileName))

        return contextPath + uploadedFileName;

    }

    public static String postUploadFile(String uploadPath, String originalName, byte[] byteData) throws Exception {
        S3Util s3 = new S3Util();
        //랜덤의 uid 를 만들어준다.
        UUID uid = UUID.randomUUID();

        //savedName : 570d570a-7af1-4afe-8ed5-391d660084b7_g.JPG 같은 형식으로 만들어준다.
        String savedName = "/" + uid.toString() + "_" + originalName;
//        String savedName = "/"+ originalName;

        logger.info("업로드 경로 : "+uploadPath);
        //\2017\12\27 같은 형태로 저장해준다.
        //String savedPath = calcPath(uploadPath);
        String savedPath = "";

        String uploadedFileName = (savedPath + savedName).replace(File.separatorChar, '/');

        //S3Util 의 fileUpload 메서드로 파일을 업로드한다.
        s3.fileUpload(bucketName, uploadPath+uploadedFileName, byteData);


        logger.info(uploadedFileName);
// s3.fileUpload(bucketName, new File(fileName))

        return contextPath + "/" + uploadPath + uploadedFileName;

    }

    public static String profileUploadFile(String uploadPath, String originalName, byte[] byteData) throws Exception {
        S3Util s3 = new S3Util();
        //랜덤의 uid 를 만들어준다.
        UUID uid = UUID.randomUUID();

        //savedName : 570d570a-7af1-4afe-8ed5-391d660084b7_g.JPG 같은 형식으로 만들어준다.
        String savedName = "/" + uid.toString() + "_" + originalName;
//        String savedName = "/"+ originalName;

        logger.info("업로드 경로 : "+uploadPath);
        //\2017\12\27 같은 형태로 저장해준다.
        //String savedPath = calcPath(uploadPath);
        String savedPath = "";

        String uploadedFileName = (savedPath + savedName).replace(File.separatorChar, '/');

        //S3Util 의 fileUpload 메서드로 파일을 업로드한다.
        s3.fileUpload(bucketName, uploadPath+uploadedFileName, byteData);


        logger.info(uploadedFileName);
// s3.fileUpload(bucketName, new File(fileName))

        return contextPath + "/" + uploadPath + uploadedFileName;


    }

    private static String calcPath(String uploadPath) {

        Calendar cal = Calendar.getInstance();

        String yearPath = File.separator + cal.get(Calendar.YEAR);

        String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);

        String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

        makeDir(uploadPath, yearPath, monthPath, datePath);

        logger.info(datePath);

        return datePath;
    }

    private static void makeDir(String uploadPath, String... paths) {

        if (new File(paths[paths.length - 1]).exists()) {
            return;
        }

        for (String path : paths) {

            File dirPath = new File(uploadPath + path);

            if (!dirPath.exists()) {
                dirPath.mkdir();
            }
        }
    }
}
