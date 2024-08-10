package com.example.myBatisBoard.repository.board;


import com.example.myBatisBoard.domain.board.GuestPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardRepository {

    /*비회원 게시글 등록*/
    void createGuestPost(GuestPost guestPost);

    /*비회원 게시판 게시글 전체출력*/
    List<GuestPost> getAllGuestPosts();


    GuestPost getGuestPostById(Long id);
}
