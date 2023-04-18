package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;

public enum Type {
    BEGIN,
    END,
    STRAIGHT,
    LEFT,
    RIGHT,
    EMPTY;

    @Getter @Setter
    private Direction direction;

}
