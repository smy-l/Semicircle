package club.banyuan.fg.refine;

import club.banyuan.fg.Player;

import java.util.Random;

public enum FingerPattern {
    ROCK("石头", 1),
    SCISSORS("剪刀", 2),
    PAPER("布", 3),
    STONE_WIN_PATTERN("121"),
    SCISSOR_WIN_PATTERN ("232");

    ;

    private String name;
    private int code;

    FingerPattern(String name) {
        this.name = name;
    }

    FingerPattern(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
