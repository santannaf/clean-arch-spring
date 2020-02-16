package com.thaleco.cleanarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Character {
    private final String name;
    private final String gender;
    private final List<Specie> species;
}
