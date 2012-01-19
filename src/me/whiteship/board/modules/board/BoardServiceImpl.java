package me.whiteship.board.modules.board;

import me.whiteship.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Keesun Baik
 */
@Service
@Transactional
public class BoardServiceImpl implements BoardService{

    @Autowired BoardRepository boardRepository;

    @Override
    public List<Board> getAll() {
        return boardRepository.getAll();
    }

    @Override
    public void add(Board board) {
        boardRepository.add(board);
    }

}
