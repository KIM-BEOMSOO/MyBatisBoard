package com.example.myBatisBoard.controller.board;

import com.example.myBatisBoard.domain.board.GuestPost;
import com.example.myBatisBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board/")
public class GuestBoardController {

    @Autowired
    private BoardService boardService;

    /*비회원 게시판*/
    @GetMapping("guestBoardMain")
    public String guestBoardMain(Model model, @RequestParam(value = "page", defaultValue = "1") int page){

        /*한 페이지에 표시할 게시글 수*/
        int pageSize = 10;
        int offset = (page - 1) * pageSize;

        /*비회원 게시글 가져오기*/
        List<GuestPost> guestPost = boardService.getAllGuestPost(pageSize, offset);

        /*비회원 게시글 수량 체크*/
        int totalPost = boardService.getGuestPostCount();
        if(totalPost == 0){
            totalPost = 1;
        }

        int totalPage = (int) Math.ceil((double) totalPost / pageSize);

        model.addAttribute("guestPost", guestPost);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPost", totalPost);

        System.out.println("totalPage => " +  totalPage);

        return "/board/guestBoardMain";
    }

    /*비회원 게시판 게시글 작성화면으로 이동*/
    @GetMapping("guestPostWrite")
    public String guestPostWrite(){
        return "/board/guestPostWrite";
    }


    /*비회원 게시글 저장*/
    @PostMapping("guestPostSave")
    public String guestPostSave(GuestPost guestPost){
        boardService.createGuestPost(guestPost);
        return "redirect:/board/guestBoardMain";
    }

    /*비회원 게시글 상세보기*/
    @GetMapping("guestPostDetail/{id}")
    public String guestPostDetail(@PathVariable Long id, Model model){
        GuestPost guestPost = boardService.getGuestPostById(id);
        model.addAttribute("guestPost", guestPost);
        return "/board/guestPostDetail";
    }

    /*비회원 게시글 수정화면*/
    @GetMapping("guestPostModifyView/{id}")
    public String guestPostModifyView(@PathVariable Long id, Model model){
            GuestPost guestPost = boardService.getGuestPostById(id);
            model.addAttribute("guestPost", guestPost);
            System.out.println("id => " + guestPost.getId());
            return "/board/guestPostModifyView";
        }

    /*비회원 게시글 수정*/
    @PostMapping("guestPostModify")
    public String guestPostModify(GuestPost guestPost
                                  ,@RequestParam String password
                                  ,Model model){

        GuestPost originalPost = boardService.getGuestPostById(guestPost.getId());

        // 비밀번호가 올바른 경우 게시글 수정
        if (originalPost != null && originalPost.getPassword().equals(password)) {
            boardService.updateGuestPost(guestPost);
            return "redirect:/board/guestBoardMain";
        } else {
            // 비밀번호가 올바르지 않은 경우 오류 메시지와 함께 수정 페이지로 돌아가기
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "/board/guestPostModifyView";
        }

    }

    /*비회원 게시글 삭제*/
    @PostMapping("guestPostDelete")
    public String guestPostDelete(GuestPost guestPost
                                  ,@RequestParam String password
                                  ,Model model){

        GuestPost originalPost = boardService.getGuestPostById(guestPost.getId());

        // 비밀번호가 올바른 경우 게시글 수정
        if (originalPost != null && originalPost.getPassword().equals(password)) {
            boardService.deleteGuestPost(guestPost.getId());
            return "redirect:/board/guestBoardMain";
        } else {
            // 비밀번호가 올바르지 않은 경우 오류 메시지와 함께 수정 페이지로 돌아가기
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("guestPost", originalPost); // 게시글 정보를 유지
            return "/board/guestPostDetail";
        }

    }



}
