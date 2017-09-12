package com.ksr.messaging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class RoomShareMessage implements Serializable {
    private String name;
    private String number;

    public RoomShareMessage(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
