package com.example.myBatisBoard.service;

import com.example.myBatisBoard.domain.board.GuestPost;
import com.example.myBatisBoard.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    /*비회원 게시글 쓰기*/
    public void createGuestPost(GuestPost guestPost){
        boardRepository.createGuestPost(guestPost);
    }

    /*비회원 게시판 게시글 전체출력*/
    public List<GuestPost> getAllGuestPosts() {
        return boardRepository.getAllGuestPosts();
    }

    public GuestPost getGuestPostById(Long id){
        return boardRepository.getGuestPostById(id);
    };
}
