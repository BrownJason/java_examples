package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Fibonacci;
import com.example.demo.entities.FizzBuzz;
import com.example.demo.entities.Palindrome;
import com.example.demo.entities.Pascal;

@Controller
public class DemoController {
	
	@GetMapping(value ="/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping(value = "/java_examples")
	public String fizzbuzz(Model model) {
		ModelMap map = new ModelMap();
		FizzBuzz fizz = new FizzBuzz();
		Fibonacci fibo = new Fibonacci();
		Palindrome pali = new Palindrome();
		Pascal pasc = new Pascal();
		map.addAttribute("fizzbuzz", fizz);
		map.addAttribute("fibonacci", fibo);
		map.addAttribute("palindrome", pali);
		map.addAttribute("pascal", pasc);
		
		model.addAllAttributes(map);
		
		return "java_examples";
	}
	
	@RequestMapping(value="/fizzbuzz", params="numb", method=RequestMethod.GET)
	public String calculate(@RequestParam int numb, @ModelAttribute("fizzbuzz")FizzBuzz fizzbuzz, ModelMap model) {
		StringBuilder res = new StringBuilder();
		if(fizzbuzz.getNumb() != 0) {
			for(int start = 1; start <= fizzbuzz.getNumb(); start++) {
				res.append(start % 10 == 3 ? "lucky "
	                    : start / 10 % 10 == 3 ? "lucky "
	                            : start % 15 == 0 ? "fizzbuzz "
	                                : start % 5 == 0 ? "buzz "
	                                    : start % 3 == 0 ? "fizz "
	                                        : start + " ");
			}
		}
		model.addAttribute("fizzbuzz", res.toString());
		
		return "java_examples/fizzbuzz";
	}
	
	@RequestMapping(value="/palindrome", params="word", method=RequestMethod.GET)
	public String palindromeComp(@RequestParam String word, @ModelAttribute("palindrome")Palindrome palindrome, ModelMap model) {
		String pali = palindrome.getWord().toLowerCase();
		StringBuilder paliReverse = new StringBuilder(palindrome.getWord()).reverse();
		boolean isPali = pali.contentEquals(paliReverse);
		
		if(isPali) {
			model.addAttribute("palindrome", pali);
			model.addAttribute("palindromeReverse", paliReverse);
			model.addAttribute("isPali", isPali);
		} else {
			model.addAttribute("palindrome", pali);
			model.addAttribute("palindromeReverse", paliReverse);
			model.addAttribute("isPali", isPali);
		}
		
		return "java_examples/palindrome";
	}
	
//	@RequestMapping(value="/fibonacci", params="number",method=RequestMethod.POST)
//	public String fiboComplete(@RequestParam int number, @ModelAttribute("fibonacci")Fibonacci fibonacci, ModelMap model) {
//		StringBuilder res = new StringBuilder();
//		if(fibonacci.getNumber() != 0) {
//			 int a = 0, b = 1, c; 
//		        if (fibonacci.getNumber()  == 0) {
//		        	res.append(a); 
//		        } else {
//		        	res.append("1 ");
//			        for (int i = 2; i <= fibonacci.getNumber() ; i++) 
//			        { 
//			            c = a + b; 
//			            a = b; 
//			            b = c; 
//			            res.append(b);
//			            res.append(" ");
//			        } 
//		        }
//		}
//		
//		model.addAttribute("fibonacci", res.toString());
//		
//		return "java_examples/fibonacci";
//	}
	
	@RequestMapping(value="/fibonacci", params="number",method=RequestMethod.GET)
	public String getFiboComplete(@RequestParam int number, @ModelAttribute("fibonacci")Fibonacci fibonacci, ModelMap model) {
		StringBuilder res = new StringBuilder();
		if(fibonacci.getNumber() != 0) {
			 int a = 0, b = 1, c; 
		        if (fibonacci.getNumber()  == 0) {
		        	res.append(a); 
		        } else {
		        	res.append("1 ");
			        for (int i = 2; i <= fibonacci.getNumber() ; i++) 
			        { 
			            c = a + b; 
			            a = b; 
			            b = c; 
			            res.append(b);
			            res.append(" ");
			        } 
		        }
		}
		
		model.addAttribute("fibonacci", res.toString());
		
		return "java_examples/fibonacci";
	}
	
	@RequestMapping(value="/pascal", params="number",method=RequestMethod.GET)
	public String getPascalComplete(@RequestParam int number, @ModelAttribute("pascal")Pascal pascal, ModelMap model) {
		StringBuilder res = new StringBuilder();
		int rows = 6, coef = 1;
        for(int i = 0; i < rows; i++) {
            for(int space = 1; space < rows - i; ++space) {
                res.append("    ");
            }
            for(int j = 0; j <= i; j++) {
                if (j == 0 || i == 0)
                    coef = 1;
                else
                    coef = coef * (i - j + 1) / j;

                res.append("    "); 
                res.append(coef);
            }
            res.append(System.getProperty("line.separator"));
        }
		
		model.addAttribute("pascal", res.toString());
		
		return "java_examples/pascal";
	}
}
