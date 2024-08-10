package com.example.myBatisBoard.controller.board;

import com.example.myBatisBoard.domain.board.GuestPost;
import com.example.myBatisBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class GuestBoardController {

    @Autowired
    private BoardService boardService;

    /*비회원 게시판으로 이동*/
    @GetMapping("guestBoardMain")
    public String guestBoardMain(){
        return "/board/guestBoardMain";
    }


    /*비회원 게시판 게시글 작성화면으로 이동*/
    @GetMapping("guestBoardWrite")
    public String guestBoardWrite(Model model){
        model.addAttribute("GuestPost", new GuestPost());
        return "/board/guestBoardWrite";
    }


    /*비회원 게시글 저장*/
    @PostMapping("guestPostSave")
    public String guestPostSave(GuestPost guestPost){
        boardService.createGuestPost(guestPost);
        return "/board/guestBoardMain";
    }


}
