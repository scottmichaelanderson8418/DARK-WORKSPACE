package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ClubDto;
import com.example.demo.model.Club;
import com.example.demo.repository.ClubRepository;

@Component
public class ClubServiceImpl implements ClubService {

	private ClubRepository clubRepository;

	@Autowired
	public ClubServiceImpl(ClubRepository clubRepository) {

		this.clubRepository = clubRepository;

	}

	@Override
	public List<ClubDto> findAllClubs() {

		List<Club> clubs = clubRepository.findAll();

		List<ClubDto> clubDtoList = new ArrayList<>();

		// for (int i = 0; i < clubs.size(); i++) {
		//
		// clubDtoList.add(mapToClubDto(clubs.get(i)));
		//
		// }
		//
		// return clubDtoList;

		// Teddy's short version of return
		return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());

	}

	private ClubDto mapToClubDto(Club club) {

		ClubDto clubDto = new ClubDto();

		clubDto.setContent(club.getContent());
		clubDto.setCreatedOn(club.getCreatedOn());
		clubDto.setPhotoUrl(club.getPhotoUrl());
		clubDto.setTitle(club.getTitle());
		clubDto.setUpdatedOn(club.getUpdatedOn());

		return clubDto;

	}

}
