package com.example.myBatisBoard.repository.board;


import com.example.myBatisBoard.domain.board.GuestPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BoardRepository {

    /*비회원 게시글 등록*/
    void createGuestPost(GuestPost guestPost);

    /*게시글 수량 확인*/
    int getGuestPostCount();

    /*비회원 게시판 게시글 전체출력*/
    List<GuestPost> getAllGuestPost(@Param("limit") int pageSize, @Param("offset") int offset);

    /*비회원 게시글 상세보기*/
    GuestPost getGuestPostById(Long id);

    /*비회원 게시글 수정*/
    void updateGuestPost(GuestPost guestPost);

    /*비회원 게시글 삭제*/
    void deleteGuestPost(Long id);


}
