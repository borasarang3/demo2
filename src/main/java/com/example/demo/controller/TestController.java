package com.example.demo.controller;

import com.example.demo.dto.TestDTO;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/register")
    public void testRegister () {}

    @PostMapping("/register")
    public String testRegisterPost (TestDTO testDTO) {
        log.info("testDTO : " + testDTO);
        testService.register(testDTO);

        return "redirect:/test/list";
    }

    @GetMapping("/list")
    public void testList (Model model) {
        List<TestDTO> testDTOList = testService.list();
        model.addAttribute("testDTOList", testDTOList);
    }

}
