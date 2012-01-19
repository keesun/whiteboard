package me.whiteship.board.modules.post;

import me.whiteship.board.domain.Board;
import me.whiteship.board.domain.Post;

import java.util.List;

/**
 * @author Keesun Baik
 */
public interface PostService {

    List<Post> getAll(Board board);

}
