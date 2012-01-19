package me.whiteship.board.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: Keesun Baik
 */
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Size(min = 1, message = "please insert title")
    @NotNull
    @Column(nullable = false)
    String title;

    public Board() {
    }

    public Board(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
