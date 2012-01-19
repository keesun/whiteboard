package me.whiteship.board.modules.post;

import me.whiteship.board.domain.Board;
import me.whiteship.board.domain.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Keesun Baik
 */
@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Override
    public List<Post> getAll(Board board) {
        return null;
    }

}
