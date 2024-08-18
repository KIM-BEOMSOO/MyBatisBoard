package com.example.myBatisBoard.controller.board.guest;

import com.example.myBatisBoard.domain.board.guest.GuestPost;
import com.example.myBatisBoard.service.board.guest.GuestBoardService;
import com.example.myBatisBoard.util.paging.PagingHelper;
import com.example.myBatisBoard.util.paging.PagingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board/guest/")
public class GuestBoardController {

    @Autowired
    private GuestBoardService guestBoardService;

    /*비회원 게시판 게시글 작성화면으로 이동*/
    @GetMapping("guestPostWrite")
    public String guestPostWrite(){
        return "/board/guest/guestPostWrite";
    }

    /*Create*/
    /*비회원 게시글 작성*/
    @PostMapping("guestPostSave")
    public String guestPostSave(GuestPost guestPost){
        guestBoardService.createGuestPost(guestPost);
        return "redirect:/board/guest/guestBoardMain";
    }

    /*테스트용 비회원 게시글 생성*/
    @PostMapping("createMultiplePost")
    public String createMultiplePost() {
        guestBoardService.createMultipleGuestPost();
        return "redirect:/board/guest/guestBoardMain";
    }

    /*Read*/
    /*비회원 게시판*/
    @GetMapping("guestBoardMain")
    public String guestBoardMain(Model model,
                                 @RequestParam(value = "currentPage", defaultValue = "1") int currentPage){

        /*비회원 게시글 수량 체크*/
        int totalPost = guestBoardService.getGuestPostCount();

        /*페이징*/
        PagingInfo pagingInfo = PagingHelper.calculatePaging(totalPost, currentPage);

        /*비회원 게시글 가져오기*/
        List<GuestPost> guestPost = guestBoardService.getAllGuestPost(pagingInfo.getPageSize(), pagingInfo.getOffset());

        model.addAttribute("totalPost", totalPost);
        model.addAttribute("pagingInfo", pagingInfo);
        model.addAttribute("guestPost", guestPost);

        return "/board/guest/guestBoardMain";
    }

    /*비회원 게시글 상세보기*/
    @GetMapping("guestPostDetail/{id}")
    public String guestPostDetail(@PathVariable Long id,
                                  Model model){
        GuestPost guestPost = guestBoardService.getGuestPostById(id);
        model.addAttribute("guestPost", guestPost);
        return "/board/guest/guestPostDetail";
    }

    /*비회원 게시글 수정화면*/
    @GetMapping("guestPostModify/{id}")
    public String guestPostModify(@PathVariable Long id,
                                  Model model){
            GuestPost guestPost = guestBoardService.getGuestPostById(id);
            model.addAttribute("guestPost", guestPost);
            return "/board/guest/guestPostModify";
        }

    /*Update*/
    /*비회원 게시글 수정*/
    @PostMapping("guestPostModify")
    public String guestPostModify(GuestPost guestPost,
                                  @RequestParam String password,
                                  Model model){
        GuestPost originalPost = guestBoardService.getGuestPostById(guestPost.getId());

        // 비밀번호가 올바른 경우 게시글 수정
        if (originalPost != null && originalPost.getPassword().equals(password)) {
            guestBoardService.updateGuestPost(guestPost);
            return "redirect:/board/guest/guestBoardMain";
        } else {
            // 비밀번호가 올바르지 않은 경우 오류 메시지와 함께 수정 페이지로 돌아가기
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "/board/guest/guestPostModify";
        }
    }

    /*Delete*/
    /*비회원 게시글 삭제*/
    @PostMapping("guestPostDelete")
    public String guestPostDelete(GuestPost guestPost,
                                  @RequestParam String password,
                                  Model model){

        GuestPost originalPost = guestBoardService.getGuestPostById(guestPost.getId());

        // 비밀번호가 올바른 경우 게시글 수정
        if (originalPost != null && originalPost.getPassword().equals(password)) {
            guestBoardService.deleteGuestPost(guestPost.getId());
            return "redirect:/board/guest/guestBoardMain";
        } else {
            // 비밀번호가 올바르지 않은 경우 오류 메시지와 함께 수정 페이지로 돌아가기
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("guestPost", originalPost); // 게시글 정보를 유지
            return "/board/guest/guestPostDetail";
        }
    }
}
