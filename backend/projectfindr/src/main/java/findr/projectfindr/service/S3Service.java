package findr.projectfindr.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class S3Service {

    private Logger logger = LoggerFactory.getLogger(S3Service.class);
    @Autowired
    private AmazonS3 s3Client;
    private String defaultBucketName = "findr-images";


    public void putObject(String objectName, byte[] image){
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(image.length);
        try {
            s3Client.putObject(
                    defaultBucketName,
                    objectName,
                    new ByteArrayInputStream(image),metadata);
        } catch (AmazonServiceException serviceException) {
            logger.info("AmazonServiceException: "+ serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            logger.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
    }

    public byte[] getObject(String objectName) throws IOException {
        S3Object s3object = s3Client.getObject(defaultBucketName, objectName);
        return IOUtils.toByteArray(s3object.getObjectContent());
    }

    public void deleteObject( String objectName){
        s3Client.deleteObject(defaultBucketName, objectName);
    }

}
