package com.thaleco.cleanarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public final class Film {

    private final Long id;
    private final Long episode;
    private final String name;
    private final List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }
}