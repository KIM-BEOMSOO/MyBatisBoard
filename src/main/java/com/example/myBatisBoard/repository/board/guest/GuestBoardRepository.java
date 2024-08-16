package com.example.myBatisBoard.repository.board.guest;


import com.example.myBatisBoard.domain.board.guest.GuestPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface GuestBoardRepository {

    /*Create*/
    /*비회원 게시글 등록*/
    void createGuestPost(GuestPost guestPost);

    /*Read*/
    /*게시글 수량 확인*/
    int getGuestPostCount();

    /*비회원 게시판 게시글 전체출력*/
    List<GuestPost> getAllGuestPost(@Param("limit") int pageSize, @Param("offset") int offset);

    /*비회원 게시글 상세보기*/
    GuestPost getGuestPostById(Long id);

    /*Update*/
    /*비회원 게시글 수정*/
    void updateGuestPost(GuestPost guestPost);

    /*Delete*/
    /*비회원 게시글 삭제*/
    void deleteGuestPost(Long id);


}
