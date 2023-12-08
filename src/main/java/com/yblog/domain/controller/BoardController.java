package com.yblog.domain.controller;

import com.yblog.domain.service.IBoardService;
import com.yblog.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final IBoardService service;

    public List<Board> getBoardList(){
        return service.getBoardList();
    }

}
