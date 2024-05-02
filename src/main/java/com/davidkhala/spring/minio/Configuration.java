package com.davidkhala.spring.minio;

import io.minio.MinioClient;
import javax.annotation.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Value("${spring.cloud.aws.credentials.access-key}")
  public String accessKey;

  @Value("${spring.cloud.aws.credentials.secret-key}")
  public String secretKey;

  @Value("${spring.cloud.aws.endpoint}")
  public String minioUrl;

  @Bean
  public @Nullable MinioClient minioClient() {
    if (minioUrl.isEmpty() || accessKey.isEmpty() || secretKey.isEmpty()) {
      return null;
    }
    MinioClient.Builder builder = new MinioClient.Builder();

    builder.credentials(accessKey, secretKey);

    builder.endpoint(minioUrl);

    return builder.build();
  }
}
