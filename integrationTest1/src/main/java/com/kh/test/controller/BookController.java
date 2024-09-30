package com.kh.test.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {
	
	private final BookService service; // final or @Autowired 추가
	
	@ResponseBody // Responsebody 추가
	@GetMapping("selectAllList")
	public List<Book> selectAllList() {
		return service.selectAllList();
	}
	
}