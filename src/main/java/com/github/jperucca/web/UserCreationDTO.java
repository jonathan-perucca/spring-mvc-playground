package com.github.jperucca.web;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Value
@RequiredArgsConstructor
public class UserCreationDTO {

    @NotNull
    private String name;
}
