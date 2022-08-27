package com.example.fibonacci.fibonacci;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/fibo")
public class FibonacciController {

    private final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping
    public String getNumbers(@RequestParam(required = false) Integer first, @RequestParam(required = false) Integer second, Model model) {
          List<Integer> numbers = null;
          if (first != null && second != null) {
             numbers = fibonacciService.getNumbersAfter(first, second);
          }
          model.addAttribute("numbers", numbers);
          return "fibo";
    }
}