package com.clonelol.summoner.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Tier {
    MASTER("MASTER",600),
    DIAMOND("DIAMOND",500),
    PLATINUM("PLATINUM",400),
    GOLD("GOLD",300),
    SILVER("SILVER",200);

    private final String key;
    private final int value;
}
