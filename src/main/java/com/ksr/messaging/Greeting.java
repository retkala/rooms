package com.ksr.messaging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Greeting implements Serializable {

    private String content;

    public Greeting(String content) {
        this.content = content;
    }

}
