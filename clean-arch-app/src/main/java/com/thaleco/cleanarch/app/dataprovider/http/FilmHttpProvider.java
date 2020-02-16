package com.thaleco.cleanarch.app.dataprovider.http;

import com.thaleco.cleanarch.app.dataprovider.http.model.CharacterModel;
import com.thaleco.cleanarch.app.dataprovider.http.model.FilmModel;
import com.thaleco.cleanarch.domain.dataprovider.FilmDataProvider;
import com.thaleco.cleanarch.domain.entity.Character;
import com.thaleco.cleanarch.domain.entity.Specie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named("filmHttpProvider")
@RequiredArgsConstructor
public class FilmHttpProvider implements FilmDataProvider {

    private final RestTemplate restTemplate;
    private final SpecieHttpProvider specieHttpProvider;
    private final CharacterHttpProvider characterHttpProvider;

    @Override
    public List<Character> getCharacterFromFilm(final Integer filmId) {
        final FilmModel filmModel = this.retrieveFilmDetails(filmId);

        return filmModel.getCharactersURL()
                .stream()
                .limit(50)
                .map(characterHttpProvider::retrieveCharactersFromUrl)
                .map(this::createDomainCharacter)
                .collect(Collectors.toList());
    }

    private FilmModel retrieveFilmDetails(final Integer filmId) {

        final String url = "https://swapi.co/api/films/";
        return restTemplate
                .getForEntity(url + filmId + "?format=json",
                        FilmModel.class)
                .getBody();
    }

    private Character createDomainCharacter(final CharacterModel characterModel) {
        final List<Specie> species = characterModel.getSpeciesURL()
                .stream()
                .map(specieHttpProvider::retrieveSpecieByUrl)
                .collect(Collectors.toList());

        return Character.builder()
                .name(characterModel.getName())
                .gender(characterModel.getGender())
                .species(species)
                .build();
    }

    private HttpHeaders getHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
