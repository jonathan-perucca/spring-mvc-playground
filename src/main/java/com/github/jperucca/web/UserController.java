package com.github.jperucca.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public Result create(@RequestBody @Valid UserCreationDTO userDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.builder()
                    .response("nok")
                    .build();
        }

        return Result.builder().response("ok").build();
    }

    @GetMapping
    public Result get() {
        return Result.builder().response("test").build();
    }
}

