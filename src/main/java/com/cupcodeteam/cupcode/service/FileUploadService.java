package com.cupcodeteam.cupcode.service;

import com.cupcodeteam.cupcode.entity.Pathimage;
import com.cupcodeteam.cupcode.repository.PartnerRepository;
import com.cupcodeteam.cupcode.repository.PathImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by YusReE_MS on 4/2/2018.
 */
@Service
public class FileUploadService {

    @Value("#{'${file.acceptContentTypes}'.split(',')}")
    private List<String> acceptContentTypes;

    @Autowired
    private PathImageRepository pathImageRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    public boolean canUpload(MultipartFile file){
        Assert.notNull(file,"FileMetadata cannot be null.");
        return !file.isEmpty() && this.acceptContentTypes.stream().anyMatch(s -> file.getContentType().equalsIgnoreCase(s));
    }

    public Pathimage uploadFile(MultipartFile file){

        Pathimage pathImage = null;

        String extension = StringUtils.cleanPath(file.getOriginalFilename());
        try {

            pathImage = new Pathimage();
//            pathImage.setPath_image("dummy");
//
//            pathImage = this.pathImageRepository.save(pathImage);

            String path = "F:\\Cupcode\\" + extension;
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream( new File(path)));
            FileCopyUtils.copy(file.getInputStream(),stream);
            stream.close();
            pathImage.setPath_image(path);

            String url  = "\\Cupcode\\" + extension;
            pathImage.setUrl_image(url);
//
            return this.pathImageRepository.save(pathImage);



        }catch (IOException e){
            System.out.print("fale");
        }
        return null;
    }
}
