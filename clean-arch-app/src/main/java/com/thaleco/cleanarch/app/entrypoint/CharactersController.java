package com.thaleco.cleanarch.app.entrypoint;

import com.thaleco.cleanarch.app.entrypoint.model.CharacterModel;
import com.thaleco.cleanarch.domain.usecase.CharacterRetrieverUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class CharactersController {

    private final CharacterRetrieverUseCase usecase;

    @GetMapping("/film/{filmName}/characters")
    public ResponseEntity<List<CharacterModel>> getCharacterByFilm(@PathVariable String filmName) {
        final List<CharacterModel> characters = this.usecase.retrieveFilmCharacters(filmName)
                                                            .stream()
                                                            .map(CharacterModel::fromDomain)
                                                            .collect(toList());
        return ResponseEntity.ok(characters);
    }
}
