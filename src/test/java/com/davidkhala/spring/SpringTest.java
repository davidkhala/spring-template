package com.davidkhala.spring;

import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
public class SpringTest {
  @Autowired MinioClient minioClient;

  @Test
  public void sanCheck()
      throws ServerException,
          InsufficientDataException,
          ErrorResponseException,
          IOException,
          NoSuchAlgorithmException,
          InvalidKeyException,
          InvalidResponseException,
          XmlParserException,
          InternalException {
    assert minioClient != null;
    List<Bucket> buckets = minioClient.listBuckets();
    buckets.forEach((bucket) -> System.out.println(bucket.name()));
    assert !buckets.isEmpty();
  }
}
