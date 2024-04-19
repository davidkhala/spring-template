package com.davidkhala.spring.aws;

import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.providers.AwsRegionProvider;

@Configuration
public class Region implements AwsRegionProvider {
    @Override
    public software.amazon.awssdk.regions.Region getRegion() {
        return software.amazon.awssdk.regions.Region.AP_EAST_1;
    }
}
