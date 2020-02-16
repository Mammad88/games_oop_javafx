package ru.job4j.Chess.firuges;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest) throws IllegalStateException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    Figure copy(Cell dest);
}
