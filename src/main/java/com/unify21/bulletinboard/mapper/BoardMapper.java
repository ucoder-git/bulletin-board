package com.unify21.bulletinboard.mapper;

import com.unify21.bulletinboard.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    int boardCount(); // 곧 생성할 BoardMapper.xml 첫번째 sql 문의 id 와 같음.

    List<Board> getList();

    Board getBoard(Long boardId);
}
