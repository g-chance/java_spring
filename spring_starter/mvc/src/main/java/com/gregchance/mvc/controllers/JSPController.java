package com.gregchance.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gregchance.mvc.models.Book;
import com.gregchance.mvc.repositories.BookRepository;
import com.gregchance.mvc.services.BookService;

@Controller
public class JSPController {

	private final BookService bServ;
	private final BookRepository bRepo;
	
	public JSPController(BookService bServ, BookRepository bRepo) {
		this.bServ = bServ;
		this.bRepo = bRepo;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Book> books = bRepo.findAll();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newbook.jsp";
	}
	@GetMapping("/books/{id}")
	public String book(
			@PathVariable("id") Long id,
			Model model
			) {
		Book book = bServ.findOne(id);
		model.addAttribute("book", book);
		return "book.jsp";
	}
	@GetMapping("/books/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model
			) {
		Book book = bServ.findOne(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	@GetMapping("/books/delete/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		Book book = bServ.findOne(id);
		bRepo.delete(book);
		return "redirect:/";
	}
	
	
	@PostMapping("/books/new")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newbook.jsp";
		}
		bRepo.save(book);
		return "redirect:/";
	}
	@PostMapping("/books/edit")
	public String edit(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bRepo.save(book);
		return "redirect:/";
	}

	
}
