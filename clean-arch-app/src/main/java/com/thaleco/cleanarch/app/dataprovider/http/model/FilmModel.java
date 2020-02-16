package com.thaleco.cleanarch.app.dataprovider.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FilmModel {
    private String title;
    @JsonProperty("episode_id")
    private Integer episodeId;
    @JsonProperty("characters")
    private List<String> charactersURL;
}
