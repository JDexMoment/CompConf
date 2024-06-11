package com.example.CompConf.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UsernameNotFoundException extends RuntimeException {

    private final Long id;
}
