package com.atguigu.gmall.manage.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class UploadFileUtils {

    public static String uploadFile(MultipartFile multipartFile) {
        String url = "http:192.168.25.10";
        try {
            String file = UploadFileUtils.class.getResource("/tracker.conf").getPath();
            ClientGlobal.init(file);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") - 1);
            String[] upload_file = storageClient.upload_file(bytes, suffix, null);
            for (int i = 0; i < upload_file.length; i++) {
                url += "/" + upload_file[i];
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return url;
    }
}
