package com.bank.credit.bankcredit.service;

import com.bank.credit.bankcredit.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AppUserService {
    private RestTemplate restTemplate;

    @Autowired
    public AppUserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public AppUser saveUser(AppUser appUser) {
        HttpEntity<AppUser> entity = new HttpEntity<>(appUser);
        return restTemplate.exchange("http://localhost:8889/BANK-SECURITY/users", HttpMethod.POST, entity,  AppUser.class).getBody();
    }
    public List<AppUser> allUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.add("Authorization", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return restTemplate.exchange("http://localhost:8889/BANK-SECURITY/users", HttpMethod.GET, null,  List.class).getBody();
    }
    public AppUser get(long id) {

        return restTemplate.getForObject("http://localhost:8889/BANK-SECURITY/users/"+id, AppUser.class);
    }
}
