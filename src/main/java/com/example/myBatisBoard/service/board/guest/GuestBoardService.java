package com.example.myBatisBoard.service.board.guest;

import com.example.myBatisBoard.domain.board.guest.GuestPost;
import com.example.myBatisBoard.repository.board.guest.GuestBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBoardService {
    @Autowired
    private GuestBoardRepository boardRepository;

    /*비회원 게시글 쓰기*/
    public void createGuestPost(GuestPost guestPost){
        boardRepository.createGuestPost(guestPost);
    }

    /*비회원 게시판 게시글 전체출력*/
    public List<GuestPost> getAllGuestPost(int pageSize, int offset) {
        return boardRepository.getAllGuestPost(pageSize, offset);
    }

    /*비회원 게시글 상세보기*/
    public GuestPost getGuestPostById(Long id){
        return boardRepository.getGuestPostById(id);
    };

    /*비회원 게시글 Count*/
    public int getGuestPostCount() {
        return boardRepository.getGuestPostCount();
    }

    /*비회원 게시글 수정*/
    public void updateGuestPost(GuestPost guestPost){
        boardRepository.updateGuestPost(guestPost);
    }

    /*비회원 게시글 삭제*/
    public void deleteGuestPost(Long id){
        boardRepository.deleteGuestPost(id);
    }

}
