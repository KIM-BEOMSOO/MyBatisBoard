package com.example.myBatisBoard.domain.board.guest;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestPost {
    private Long id;
    private String name;
    private String title;
    private String content;
    private String password;
    private String is_deleted;
    private String created_at;
    private String modified_at;
}

