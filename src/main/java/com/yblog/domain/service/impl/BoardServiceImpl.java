package com.yblog.domain.service.impl;

import com.yblog.domain.service.IBoardService;
import com.yblog.entity.Board;
import com.yblog.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements IBoardService {

    private final BoardRepository repository;

    @Override
    public Board createBoard(Board Board) {
        return repository.save(Board);
    }

    @Override
    public Board updateBoard(Board Board) {
        return null;
    }

    @Override
    public Board getBoard(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Board> getBoardList() {
        return repository.findAll();
    }
}
