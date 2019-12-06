package com.pingan.rym.utils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;

/**
 * @author 刘欣武
 * @version $Id: APIUtil, v 0.1 2019/3/25 14:26 刘欣武 Exp$
 */
@Component
public class APIUtil {

    @Resource
    private RestTemplate restTemplate;

    public String sendGetRequest(String url,Map<String,String> params){
        HttpHeaders httpHeaders = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if(params!=null && params.size()>0){
            MultiValueMap<String, String> paramsR = new LinkedMultiValueMap<>();
            params.keySet().forEach(item->{
                paramsR.add(item,params.get(item));
            });
            builder.queryParams(paramsR);
        }
        HttpEntity<Object> entity = new HttpEntity<>(httpHeaders);
        URI uri = builder.build().encode().toUri();
        HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String sendPostRequest(String url,Map<String,String> params){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        MultiValueMap<String, String> paramsR = new LinkedMultiValueMap<>();
        params.keySet().forEach(item->{
            paramsR.add(item,params.get(item));
        });
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(paramsR, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }


}


