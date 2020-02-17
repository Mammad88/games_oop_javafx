package ru.job4j.Chess;

import ru.job4j.Chess.Exception.FigureNotFoundException;
import ru.job4j.Chess.Exception.ImpossibleMoveException;
import ru.job4j.Chess.Exception.OccupiedWayException;
import ru.job4j.Chess.firuges.Cell;
import ru.job4j.Chess.firuges.Figure;

import java.util.Arrays;

/**
 * Класс с логикой шахмат.
 *
 * @author Bruki Mammad (bruki_mammad@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Метод осуществляет перемещение на заданную позицию.
     *
     * @param source исходная позиция.
     * @param dest   конечная позиция.
     * @return true в случае если фигура может двигаться в заданном направлении.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
            OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            for (Cell step : steps) {
                if (this.findBy(step) != -1) {
                    throw new OccupiedWayException();
                }
            }
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Метод findBy - осуществляет поиск фигуры на доске.
     *
     * @param cell - текущая позиция фигуры.
     * @return фигуру на данной позиции.
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
