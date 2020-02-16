package com.thaleco.cleanarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Specie {
    private final String name;
    private final String language;
}
