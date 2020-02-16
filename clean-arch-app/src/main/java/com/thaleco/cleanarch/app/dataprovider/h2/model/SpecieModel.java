package com.thaleco.cleanarch.app.dataprovider.h2.model;

import com.thaleco.cleanarch.domain.entity.Specie;
import lombok.Builder;

@Builder
public class SpecieModel {

    private String name;
    private String language;

    public static SpecieModel fromDomain(final Specie specie) {
        return SpecieModel.builder()
                .name(specie.getName())
                .language(specie.getLanguage())
                .build();
    }

    public Specie toDomain() {
        return Specie.builder()
                .name(name)
                .language(language)
                .build();
    }
}
