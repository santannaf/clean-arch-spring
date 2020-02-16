package com.thaleco.cleanarch.domain.usecase;

import com.thaleco.cleanarch.domain.dataprovider.FilmDataProvider;
import com.thaleco.cleanarch.domain.entity.Character;
import com.thaleco.cleanarch.domain.usecase.exception.BusinessException;

import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class CharacterRetrieverUseCase {

    private final FilmDataProvider filmDataProvider;
    private final Map<String, Integer> filmTitleManager;

    public CharacterRetrieverUseCase(   FilmDataProvider filmDataProvider,
                                        Map<String, Integer> filmTitleManager
                                    ) {
        this.filmDataProvider = filmDataProvider;
        this.filmTitleManager = filmTitleManager;
    }

    public List<Character> retrieveFilmCharacters(final String filmTitle) {
        final Integer filmId = filmTitleManager.get(filmTitle.toLowerCase());

        if (filmId == null) {
            throw new BusinessException("Invalid Film Name");
        }
        return filmDataProvider.getCharacterFromFilm(filmId);
    }
}
