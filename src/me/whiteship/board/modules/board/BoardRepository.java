package me.whiteship.board.modules.board;

import me.whiteship.board.domain.Board;

import java.util.List;

/**
 * @author Keesun Baik
 */
public interface BoardRepository {
    List<Board> getAll();

    void add(Board board);
}
