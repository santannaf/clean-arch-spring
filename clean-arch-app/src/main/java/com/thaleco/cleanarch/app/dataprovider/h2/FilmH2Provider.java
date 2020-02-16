/*
package com.thaleco.cleanarch.app.dataprovider.h2;

import com.thaleco.cleanarch.app.dataprovider.h2.model.CharacterModel;
import com.thaleco.cleanarch.app.dataprovider.h2.model.FilmModel;
import com.thaleco.cleanarch.app.dataprovider.h2.repository.FilmModelRepository;
import com.thaleco.cleanarch.domain.dataprovider.FilmDataProvider;
import com.thaleco.cleanarch.domain.entity.Character;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Named("filmH2Provider")
@RequiredArgsConstructor
public class FilmH2Provider implements FilmDataProvider {

    private final FilmModelRepository repository;

    @Override
    public List<Character> getCharacterFromFilm(Integer filmId) {
        return repository.findById(filmId)
                .orElse(FilmModel.DEFAULT)
                .getCharacters()
                .stream()
                .map(CharacterModel::toDomain)
                .collect(toList());
    }
}
*/
