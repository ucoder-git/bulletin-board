package com.unify21.bulletinboard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.unify21.bulletinboard.service.BoardService;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor  //추가1
public class BoardController {

    private final BoardController service;  //추가2

    @GetMapping("/hello")
    public String Hello() {
        return "/boards/hello";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.boardList());

        return "/boards/hello";
    }

    private Object boardCount() {
    }

    // 추가
    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("list", service.boardList());

        return "/boards/main";
    }

    private Object boardList() {
        return null;
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId) {
        model.addAttribute("halo", service.getBoard(boardId));

        return "/boards/view";
    }

    private Object getBoard(Long boardId) {
        return null;
    }

}
