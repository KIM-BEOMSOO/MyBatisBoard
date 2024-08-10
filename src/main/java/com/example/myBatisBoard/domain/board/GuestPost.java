package com.example.myBatisBoard.domain.board;


import lombok.Getter;
import lombok.Setter;


public class GuestPost {
    private Long id;
    private String guestPostTitle;
    private String guestPostContent;
    private String guestPostPw;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestPostTitle() {
        return guestPostTitle;
    }

    public void setGuestPostTitle(String guestPostTitle) {
        this.guestPostTitle = guestPostTitle;
    }

    public String getGuestPostContent() {
        return guestPostContent;
    }

    public void setGuestPostContent(String guestPostContent) {
        this.guestPostContent = guestPostContent;
    }

    public String getGuestPostPw() {
        return guestPostPw;
    }

    public void setGuestPostPw(String guestPostPw) {
        this.guestPostPw = guestPostPw;
    }
}

