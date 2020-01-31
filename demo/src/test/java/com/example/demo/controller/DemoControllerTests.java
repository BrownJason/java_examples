package com.example.demo.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Fibonacci;
import com.example.demo.entities.FizzBuzz;
import com.example.demo.entities.Palindrome;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTests {


	@Test
	public void fizzbuzzEqual() {
		FizzBuzz fizz = new FizzBuzz();
		fizz.setNumb(10);
		
		StringBuilder res = new StringBuilder();
		if(fizz.getNumb() != 0) {
			for(int start = 1; start <= fizz.getNumb(); start++) {
				res.append(start % 10 == 3 ? "lucky "
	                    : start / 10 % 10 == 3 ? "lucky "
	                            : start % 15 == 0 ? "fizzbuzz "
	                                : start % 5 == 0 ? "buzz "
	                                    : start % 3 == 0 ? "fizz "
	                                        : start + " ");
			}
		}
		assertEquals(res.toString().trim(), 
				"1 2 lucky 4 buzz fizz 7 8 fizz buzz");
	}
	
	@Test
	public void fizzbuzzNotEqual() {
		FizzBuzz fizz = new FizzBuzz();
		fizz.setNumb(10);
		
		StringBuilder res = new StringBuilder();
		if(fizz.getNumb() != 0) {
			for(int start = 1; start <= fizz.getNumb(); start++) {
				res.append(start % 10 == 3 ? "lucky "
	                    : start / 10 % 10 == 3 ? "lucky "
	                            : start % 15 == 0 ? "fizzbuzz "
	                                : start % 5 == 0 ? "buzz "
	                                    : start % 3 == 0 ? "fizz "
	                                        : start + " ");
			}
		}
		assertNotEquals(res.toString().trim(), 
				"1 2 lucky 4 buzz fizz 7 8 fizz");
	}
	
	@Test
	public void paliTrue() {
		Palindrome pal = new Palindrome();
		pal.setWord("lol");
		
		assertEquals(new StringBuilder(pal.getWord()).reverse().toString(), pal.getWord());
	}
	
	@Test 
	public void paliFalse() {
		Palindrome pal = new Palindrome();
		pal.setWord("okoi");
		
		assertNotEquals(new StringBuilder(pal.getWord()).reverse().toString(), pal.getWord());
	}
	
	@Test
	public void fibonacciTrue() {
		Fibonacci fibo = new Fibonacci();
		fibo.setNumber(3);
		
		StringBuilder res = new StringBuilder();
		if(fibo.getNumber() != 0) {
			 int a = 0, b = 1, c; 
		        if (fibo.getNumber()  == 0) {
		        	res.append(a); 
		        } else {
		        	res.append("1 ");
			        for (int i = 2; i <= fibo.getNumber() ; i++) 
			        { 
			            c = a + b; 
			            a = b; 
			            b = c; 
			            res.append(b);
			            res.append(" ");
			        } 
		        }
		}
		
		assertEquals(res.toString().trim(), "1 1 2");
	}
	
	@Test
	public void fibonacciFalse() {
		Fibonacci fibo = new Fibonacci();
		fibo.setNumber(3);
		
		StringBuilder res = new StringBuilder();
		if(fibo.getNumber() != 0) {
			 int a = 0, b = 1, c; 
		        if (fibo.getNumber()  == 0) {
		        	res.append(a); 
		        } else {
		        	res.append("1 ");
			        for (int i = 2; i <= fibo.getNumber() ; i++) 
			        { 
			            c = a + b; 
			            a = b; 
			            b = c; 
			            res.append(b);
			            res.append(" ");
			        } 
		        }
		}
		
		assertNotEquals(res.toString().trim(), "1 1 2 3");
	}
}
