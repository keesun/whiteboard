package me.whiteship.board.modules.board;

import me.whiteship.board.domain.Board;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Keesun Baik
 */
@Repository
public class BoardRepositoryHibernate implements BoardRepository{

    @Autowired SessionFactory sessionFactory;


    @Override
    public List<Board> getAll() {
        return getSession().createCriteria(Board.class).list();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Board board) {
        getSession().save(board);
    }
}
