package ru.job4j.Chess.firuges.black;

import ru.job4j.Chess.Exception.ImpossibleMoveException;
import ru.job4j.Chess.firuges.Cell;
import ru.job4j.Chess.firuges.Figure;

import java.util.Arrays;

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
            throw new ImpossibleMoveException();
        }
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        int deltaX = (dest.x - source.x) < 0 ? -1 : 1;
        int deltaY = (dest.y - source.y) < 0 ? -1 : 1;
        for (int index = 0; index < Math.abs(dest.x - source.x); index++) {
            steps[index] = findStepCell(source.x + (index + 1) * deltaX, source.y + (index + 1) * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            result = true;
        }
        return result;
    }

    private Cell findStepCell(int x, int y) {
        return Arrays.stream(Cell.values())
                .filter(cell -> cell.x == x && cell.y == y)
                .findFirst()
                .orElseThrow(ImpossibleMoveException::new);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
