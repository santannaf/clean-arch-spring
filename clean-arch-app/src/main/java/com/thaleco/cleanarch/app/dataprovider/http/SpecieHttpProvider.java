package com.thaleco.cleanarch.app.dataprovider.http;

import com.thaleco.cleanarch.app.dataprovider.http.model.SpecieModel;
import com.thaleco.cleanarch.domain.entity.Specie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import java.util.Collections;

@Named
@RequiredArgsConstructor
public class SpecieHttpProvider {
    private final RestTemplate restTemplate;

    public Specie retrieveSpecieByUrl(final String specieUrl) {
        return restTemplate
                .exchange(specieUrl,
                        HttpMethod.GET,
                        new HttpEntity<String>(getHeaders()),
                        SpecieModel.class)
                .getBody()
                .toDomain();
    }

    private HttpHeaders getHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
