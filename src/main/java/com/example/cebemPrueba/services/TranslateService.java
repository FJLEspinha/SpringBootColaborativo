package com.example.cebemPrueba.services;

import com.example.cebemPrueba.models.Translate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslateService {

    @Autowired
    RestTemplate restTemplate;

    public Translate getTranslateFromAPI(@PathVariable String segment) {
        String url = "https://api.mymemory.translated.net/get?q="+segment+"&langpair=es|en";
        return restTemplate.getForObject(url, Translate.class);
    }

}
