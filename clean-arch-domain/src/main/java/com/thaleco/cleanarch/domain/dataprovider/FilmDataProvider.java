package com.thaleco.cleanarch.domain.dataprovider;

import com.thaleco.cleanarch.domain.entity.Character;

import java.util.List;

public interface FilmDataProvider {
    List<Character> getCharacterFromFilm(Integer filmTitle);
}
