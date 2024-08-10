package com.example.myBatisBoard.service;

import com.example.myBatisBoard.domain.board.GuestPost;
import com.example.myBatisBoard.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void createGuestPost(GuestPost guestPost){
        boardRepository.createGuestPost(guestPost);
    }

}
