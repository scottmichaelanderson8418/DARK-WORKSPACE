
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.ClubDto;
import com.example.demo.service.impl.ClubService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;

	public ClubController(ClubService clubService) {

		this.clubService = clubService;

	}

	@GetMapping("/clubs")
	public String listClubs(Model model) {

		// returns the clubs in dto format
		List<ClubDto> clubs = clubService.findAllClubs();

		// adds attribute to the model so it can be injected onto the webpage
		model.addAttribute("clubs", clubs);

		return "clubs-list";
	}

}
