package com.davidkhala.spring.aws;

import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class S3 {
  @Autowired private S3Template s3Template;

  @PostMapping("/s3/{bucket}/{name}")
  public void upload(
      @PathVariable String bucket,
      @PathVariable String name,
      @RequestParam("file") MultipartFile file)
      throws IOException {
    s3Template.upload(bucket, name, file.getInputStream());
  }

  @GetMapping("/s3/{bucket}")
  public String list(@PathVariable String bucket) {
    List<S3Resource> list = s3Template.listObjects(bucket, "");
    list.forEach(System.out::println);
    return list.stream()
        .map(S3Resource::getFilename)
        .reduce("", (result,s) -> {
            assert result != null;
            return result.isBlank() ? s : result + "," + s;
        });
  }
}
