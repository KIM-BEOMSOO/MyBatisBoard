package com.example.myBatisBoard.domain.board;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestPost {
    private Long id;
    private String guestPostTitle;
    private String guestPostContent;
    private String guestPostPw;
}

