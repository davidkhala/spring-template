package com.davidkhala.spring.aws;

import io.awspring.cloud.s3.S3Template;
import org.springframework.stereotype.Repository;

import java.io.InputStream;

@Repository
public class S3 {
    private final S3Template s3Template;

    public S3(S3Template s3Template) {
        this.s3Template = s3Template;
    }

    public void upload(String BUCKET, String name, InputStream is) {

// uploading file without metadata
        s3Template.upload(BUCKET, name, is);
//        No region provided in profile

    }


}
