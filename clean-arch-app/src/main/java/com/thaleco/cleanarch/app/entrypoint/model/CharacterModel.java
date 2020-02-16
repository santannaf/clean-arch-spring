package com.thaleco.cleanarch.app.entrypoint.model;

import com.thaleco.cleanarch.domain.entity.Character;
import com.thaleco.cleanarch.domain.entity.Specie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterModel {
    private String name;
    private String gender;
    private List<String> specie;

    public static CharacterModel fromDomain(final Character character) {
        return CharacterModel.builder()
                .name(character.getName())
                .gender(character.getName())
                .specie(getSpeciesName(character))
                .build();
    }

    private static List<String> getSpeciesName(final Character character) {
        return character.getSpecies().stream().map(Specie::getName).collect(Collectors.toList());
    }
}
