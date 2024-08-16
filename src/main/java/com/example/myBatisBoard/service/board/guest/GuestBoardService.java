package com.example.myBatisBoard.service.board.guest;

import com.example.myBatisBoard.domain.board.guest.GuestPost;
import com.example.myBatisBoard.repository.board.guest.GuestBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class GuestBoardService {
    @Autowired
    private GuestBoardRepository GuestBoardRepository;

    /*Create*/
    /*비회원 게시글 쓰기*/
    public void createGuestPost(GuestPost guestPost){
        GuestBoardRepository.createGuestPost(guestPost);
    }

    /*테스트용 비회원 게시글 생성*/
    @Transient
    public void createMultipleGuestPost(){
        for (int i = 1; i <= 100; i++) {
            GuestPost post = new GuestPost(
                    "User" + i,
                    "Title " + i,
                    "This is content for post " + i,
                    "password" + i
            );
            GuestBoardRepository.createGuestPost(post);
        }
    }

    /*Read*/
    /*비회원 게시판 게시글 전체출력*/
    public List<GuestPost> getAllGuestPost(int pageSize, int offset) {
        return GuestBoardRepository.getAllGuestPost(pageSize, offset);
    }

    /*비회원 게시글 상세보기*/
    public GuestPost getGuestPostById(Long id){
        return GuestBoardRepository.getGuestPostById(id);
    };

    /*비회원 게시글 Count*/
    public int getGuestPostCount() {
        return GuestBoardRepository.getGuestPostCount();
    }

    /*Update*/
    /*비회원 게시글 수정*/
    public void updateGuestPost(GuestPost guestPost){
        GuestBoardRepository.updateGuestPost(guestPost);
    }

    /*Delete*/
    /*비회원 게시글 삭제*/
    public void deleteGuestPost(Long id){
        GuestBoardRepository.deleteGuestPost(id);
    }

}
