package ru.job4j.Chess.firuges.black;

import ru.job4j.Chess.firuges.Cell;
import ru.job4j.Chess.firuges.Figure;

/**
 * @author Bruki Mammad (bruki_mammad@mail.ru )
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }


    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Метод реализует логику перемещения фигуры "Слон".
     *
     * @param source начальная позиция.
     * @param dest   конечная позиция.
     * @return массив содержащий шаги фигуры.
     * @throws IllegalStateException фигура не может так двигаться по диагонали.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            int deltaX = (source.x < dest.x) ? source.x + index + 1 : source.x - index - 1;
            int deltaY = (source.y < dest.y) ? source.y + index + 1 : source.y - index - 1;
            steps[index] = Cell.findBy(deltaX, deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        return true;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
