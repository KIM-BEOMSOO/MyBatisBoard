package com.example.myBatisBoard.repository.board;


import com.example.myBatisBoard.domain.board.GuestPost;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BoardRepository {

    /*비회원 게시글 등록*/
    void createGuestPost(GuestPost guestPost);


}
