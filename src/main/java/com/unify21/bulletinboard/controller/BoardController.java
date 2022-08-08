package com.unify21.bulletinboard.controller;

import com.unify21.bulletinboard.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/upload")
    public String uploadBoardForm() {
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board) {
        service.uploadBoard(board);
        return "redirect:/board/main"; // 디렉토리가 아니라 주소라 board 임.
    }

    @GetMapping("/update")
    public String updateBoardForm(Model model, Long boardId) {
        model.addAttribute("update", service.getBoard(boardId));

        return "/boards/update";
    }

    @PostMapping("/update")
    public String updateBoard(Board board) {
        service.updateBoard(board);
        return "redirect:/board/main";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long boardId) {
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId) {
        service.viewCount(boardId); // 추가
        model.addAttribute("halo", service.getBoard(boardId));

        return "/boards/view";
    }

    private void viewCount(Long boardId) {
    }

}
