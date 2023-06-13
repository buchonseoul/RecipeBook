package com.buchonsi.recipebook.openapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
public class RecipeCenter {
    private Logger log = LoggerFactory.getLogger(String.class);
    @Value("${openApi.secretKey}")
    private String SECRET_KEY;
    private static String BASE_URL = "http://openapi.foodsafetykorea.go.kr";
    private static String SERVICE_NAME = "COOKRCP01";
    private static String SERVICE_TYPE = "JSON";

//    public WebClient getConnection() {
//        return 0
//    }


    public String getRecipe() {
        String startPoint = "1";
        String endPoint = "10";

        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL)
                .append("/api")
                .append("/")
                .append(SECRET_KEY)
                .append("/")
                .append(SERVICE_NAME)
                .append("/")
                .append(SERVICE_TYPE)
                .append("/")
                .append(startPoint)
                .append("/")
                .append(endPoint);

        String baseUrl = sb.toString();

        log.info("baseUrl = " + baseUrl);

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(baseUrl)
                .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
