package ru.job4j.Chess.firuges;

import ru.job4j.Chess.Exception.ImpossibleMoveException;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest) throws IllegalStateException, ImpossibleMoveException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    Figure copy(Cell dest);
}
