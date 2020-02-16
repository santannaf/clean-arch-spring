package com.thaleco.cleanarch.app.dataprovider.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CharacterModel {
    private String name;
    private String gender;
    @JsonProperty("species")
    private List<String> speciesURL;
}
