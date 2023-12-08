package com.yblog.domain.service;

import com.yblog.entity.Board;

import java.util.List;

public interface IBoardService {

    Board createBoard(Board Board);
    Board updateBoard(Board Board);
    Board getBoard(long id);
    List<Board> getBoardList();

}
