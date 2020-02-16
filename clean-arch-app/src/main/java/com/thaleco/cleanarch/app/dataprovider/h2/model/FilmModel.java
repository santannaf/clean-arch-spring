package com.thaleco.cleanarch.app.dataprovider.h2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
/*@Entity*/
public class FilmModel {

    public static final FilmModel DEFAULT = FilmModel.builder()
            .title("")
            .build();

    @Id
    private Integer id;
    private String title;
    @JsonProperty("episode_id")
    private Integer episodeId;
    private List<CharacterModel> characters;
}
