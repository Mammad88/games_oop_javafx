package ru.job4j.Chess.logic;

import org.junit.Test;
import ru.job4j.Chess.Logic;
import ru.job4j.Chess.firuges.Cell;
import ru.job4j.Chess.firuges.black.BishopBlack;
import ru.job4j.Chess.firuges.black.PawnBlack;

/**
 * @author Bruki Mammad (bruki_mammad@mail.ru)
 * @version 1.0
 * @since 15.02.2020
 */
public class LogicTest {

    @Test
    public void whenBlackBishopMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E6);
        PawnBlack pawnBlack = new PawnBlack(Cell.D5);
        Logic logic = new Logic();
        logic.add(pawnBlack);
        logic.add(bishopBlack);
        logic.move(Cell.E6, Cell.B3);
    }
}
