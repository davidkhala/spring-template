package com.davidkhala.spring;

import com.davidkhala.spring.aws.S3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/s3/{bucket}/{name}")
    public void Upload(S3 s3, @PathVariable String bucket, @PathVariable String name, @RequestParam("file") MultipartFile file) throws IOException {
        s3.upload(bucket, name, file.getInputStream());
    }

}
