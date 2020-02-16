package com.thaleco.cleanarch.app.dataprovider.h2.model;

import com.thaleco.cleanarch.domain.entity.Character;
import com.thaleco.cleanarch.domain.entity.Specie;
import lombok.Builder;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Builder
public class CharacterModel {
    private String name;
    private String gender;
    private List<SpecieModel> species;

    public static CharacterModel fromDomain(final Character character) {
        return CharacterModel.builder()
                .name(character.getName())
                .gender(character.getGender())
                .species(getSpeciesModel(character))
                .build();
    }

    private static List<SpecieModel> getSpeciesModel(Character character) {
        return character.getSpecies().stream()
                .map(SpecieModel::fromDomain)
                .collect(toList());
    }

    public Character toDomain() {
        return Character.builder()
                .name(name)
                .gender(gender)
                .species(getSpecies())
                .build();
    }

    private List<Specie> getSpecies() {
        return species.stream().map(SpecieModel::toDomain).collect(toList());
    }
}
