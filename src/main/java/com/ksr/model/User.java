package com.ksr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    String name;

    User(String name) {
        this.name = name;
    }
}
