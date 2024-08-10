package com.example.myBatisBoard.controller.board;

import com.example.myBatisBoard.domain.board.GuestPost;
import com.example.myBatisBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board/")
public class GuestBoardController {

    @Autowired
    private BoardService boardService;

    /*비회원 게시판*/
    @GetMapping("guestBoardMain")
    public String guestBoardMain(Model model){
        List<GuestPost> guestPosts = boardService.getAllGuestPosts();
        model.addAttribute("guestPosts", guestPosts);
        return "/board/guestBoardMain";
    }

    /*비회원 게시판 게시글 작성화면으로 이동*/
    @GetMapping("guestBoardWrite")
    public String guestBoardWrite(){
        return "/board/guestBoardWrite";
    }


    /*비회원 게시글 저장*/
    @PostMapping("guestPostSave")
    public String guestPostSave(GuestPost guestPost){
        boardService.createGuestPost(guestPost);
        return "redirect:/board/guestBoardMain";
    }

    /*비회원 게시글 상세보기*/
    @GetMapping("guestPost/{id}")
    public String guestPostDetail(@PathVariable Long id, Model model){
        GuestPost guestPost = boardService.getGuestPostById(id);
        model.addAttribute("guestPost", guestPost);
        return "/board/guestPostDetail";
    }


}
