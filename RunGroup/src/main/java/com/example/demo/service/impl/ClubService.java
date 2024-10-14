package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClubDto;

@Service
public interface ClubService {

	List<ClubDto> findAllClubs();

}
