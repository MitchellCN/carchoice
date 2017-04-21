package com.carchoice;

import java.io.IOException;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.github.kevinsawicki.http.*;

import java.util.Arrays;
import java.util.List;

@Component
public class CarQueryService {

    @Value("${carquery.api.apiurl}")
    String apiUrl;


    public List<Make> listMakes() throws IOException {
        String response = Request.Get("https://www.carqueryapi.com/api/0.3/?cmd=getMakes&year=2000&sold_in_us=1")
                .addHeader("Accept", "application/json; charset=utf-8")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
                .execute().returnContent().asString();

        return new Gson().fromJson(response, Makes.class).getMakes();
    }









//    public List<Make> listMakes() {
//
//        RestTemplate restTemplate = new RestTemplate()Makes makes = restTemplate.getForObject(
//                apiUrl + "&cmd=getMakes",
//                Makes.class);
//
//
//
//        return makes.getMakes();
//
//
//    }
}