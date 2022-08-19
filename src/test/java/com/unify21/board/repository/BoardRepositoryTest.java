package com.unify21.board.repository;

import com.unify21.board.BoardApplicationTests;
import com.unify21.board.model.entity.Board;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class BoardRepositoryTest extends BoardApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void create()
    {
        Board board = new Board();
        board.setTitle("Hello");
        board.setWriter("Andrew");
        board.setContent("This is a post for final project!");

        Board newBoard = boardRepository.save(board);
        System.out.println("newPost : " + newBoard);
    }

    @Test
    public void read()
    {
        Optional<Board> post = boardRepository.findById(1L);
        post.ifPresent(selectBoard ->{
            System.out.println("post : " + post);
        });
    }

    @Test
    @Transactional
    public void update()
    {
        Optional<Board> post = boardRepository.findById(1L);
        post.ifPresent(selectBoard ->{
            selectBoard.setTitle("Modfied Title");
            selectBoard.setContent("I just modified");

            boardRepository.save(selectBoard);
        });
    }

    @Test
    @Transactional
    public void delete()
    {

        Optional<Board> post = boardRepository.findById(1L);
        Assert.assertTrue(post.isPresent());

        post.ifPresent(selectBoard ->{
            boardRepository.delete(selectBoard);
        });

        Optional<Board> deletePost = boardRepository.findById(1L);

        Assert.assertFalse(deletePost.isPresent());

    }

}
