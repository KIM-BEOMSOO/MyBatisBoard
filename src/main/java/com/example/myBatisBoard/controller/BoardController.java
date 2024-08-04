package com.example.myBatisBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BoardController {

    @RequestMapping("/board/boardMain")
    public String boardMain(){
        return "/board/boardMain";
    }



}
