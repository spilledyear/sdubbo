package com.sxy.dubbo27;

import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDubbo
public class Dubbo27Application {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo27Application.class, args);
    }


    @Configuration
    @PropertySource("classpath:/dubbo-provider.properties")
    static class ProviderConfiguration {
        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
//            registryConfig.setAddress("multicast://224.5.6.7:1234");
//            registryConfig.setAddress("nacos://10.9.44.133:8848");
            registryConfig.setAddress("zookeeper://localhost:2181");

            // 注册简化版的的url到注册中心
            registryConfig.setSimplified(true);
            return registryConfig;
        }


        @Bean
        public MetadataReportConfig metadataReportConfig() {
            MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
            metadataReportConfig.setAddress("zookeeper://localhost:2181");
//            metadataReportConfig.setAddress("redis://localhost:6379");
            return metadataReportConfig;
        }


//        @Bean
//        public ConfigCenterConfig configCenterConfig() {
//            ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
////            configCenterConfig.setAddress("nacos://10.9.44.133:8848");
//            configCenterConfig.setAddress("zookeeper://127.0.0.1:2181");
//            return configCenterConfig;
//        }
    }

}