package com.thaleco.cleanarch.app.config.H2;

import com.thaleco.cleanarch.app.dataprovider.h2.model.CharacterModel;
import com.thaleco.cleanarch.app.dataprovider.h2.model.FilmModel;
import com.thaleco.cleanarch.domain.dataprovider.FilmDataProvider;
import com.thaleco.cleanarch.domain.entity.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Slf4j
@Configuration
@Profile("h2")
public class PrepareData implements ApplicationRunner {
    private final FilmDataProvider filmHttpProvider;
    /*private final FilmModelRepository repository;*/
    private final Map<String, Integer> filmTitleManager;

    public PrepareData(
            @Qualifier("filmHttpProvider") FilmDataProvider filmHttpProvider,
            /*FilmModelRepository repository,*/
            Map<String, Integer> filmTitleManager) {
        this.filmHttpProvider = filmHttpProvider;
/*        this.repository = repository;*/
        this.filmTitleManager = filmTitleManager;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
/*        if (repository.count() > 0) {
            return;
        }

        filmTitleManager.entrySet().stream()
                .map(this::getFilmsModel)
                .forEach(repository::save);

        log.info("finished prepare data");*/
    }

    private FilmModel getFilmsModel(Map.Entry<String, Integer> filmManager) {
        final List<Character> characters = filmHttpProvider
                .getCharacterFromFilm(filmManager.getValue());

        return FilmModel.builder()
                .id(filmManager.getValue())
                .title(filmManager.getKey())
                .episodeId(filmManager.getValue())
                /*.characters(getCharactersModel(characters))*/
                .build();
    }

    private List<CharacterModel> getCharactersModel(List<Character> characters) {
        return characters.stream()
                .map(CharacterModel::fromDomain)
                .collect(toList());
    }
}
