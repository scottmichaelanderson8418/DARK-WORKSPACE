package com.pokemonreview.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pokemonreview.dto.PrintDrawingDto;
import com.pokemonreview.dto.PrintDrawingResponse;
import com.pokemonreview.exceptions.PokemonNotFoundException;
import com.pokemonreview.model.PrintDrawing;
import com.pokemonreview.repository.PrintDrawingRespository;
import com.pokemonreview.service.PrintDrawingService;

@Service
public class PrintDrawingServiceImpl implements PrintDrawingService {

	PrintDrawingRespository printDrawingRepository;

	@Autowired
	public PrintDrawingServiceImpl(PrintDrawingRespository printRepository) {

		this.printDrawingRepository = printRepository;

	}

	@Override
	public PrintDrawingDto createPrint(PrintDrawingDto printDrawingDto) {

		System.out.println("PrintServiceImpl-->createPrint(Print printDto)");
		// FIXME Auto-generated method stub

		// copy created PrintDto to Print Object
		PrintDrawing printDrawing = new PrintDrawing();
		printDrawing.setBearingMax(printDrawingDto.getBearingMax());
		printDrawing.setBearingMin(printDrawingDto.getBearingMin());
		printDrawing.setCust(printDrawingDto.getCust());
		printDrawing.setCustPin(printDrawingDto.getCustPin());
		printDrawing.setCustRev(printDrawingDto.getCustRev());
		printDrawing.setDate(printDrawingDto.getDate());
		printDrawing.setDateCreated(printDrawingDto.getDateCreated());
		printDrawing.setDia1(printDrawingDto.getDia1());
		printDrawing.setDia2(printDrawingDto.getDia2());
		printDrawing.setDwgPath(printDrawingDto.getDmgDrawingPath());
		printDrawing.setDrawingName(printDrawingDto.getDrawingName());
		printDrawing.setFace1(printDrawingDto.getFace2());
		printDrawing.setOem(printDrawingDto.getOem());
		printDrawing.setOriginatingCustomer(printDrawingDto.getOriginatingCustomer());
		printDrawing.setPartNo(printDrawingDto.getPartNo());
		printDrawing.setPdfPath(printDrawingDto.getPdfPath());
		printDrawing.setPrevPartNo(printDrawingDto.getPrevPartNo());
		printDrawing.setProductCode(printDrawingDto.getProductCode());
		printDrawing.setRevNumber(printDrawingDto.getRevNumber());
		printDrawing.setScannedPath(printDrawingDto.getScannedPath());
		printDrawing.setSteps(printDrawingDto.getSteps());
		printDrawing.setType(printDrawingDto.getType());
		printDrawing.setSubcontractor(printDrawingDto.getSubcontractor());
		printDrawing.setType(printDrawingDto.getType());
		printDrawing.setXlsmPath(printDrawingDto.getXlsmPath());
		printDrawing.setXlsxPath(printDrawingDto.getXlsxPath());

		PrintDrawing newPrint = printDrawingRepository.save(printDrawing);

		// copy created Print to PrintDto Object
		PrintDrawingDto printResponse = new PrintDrawingDto();

		// Transfer data from Print to printResponse
		printResponse.setBearingMax(printDrawing.getBearingMax());
		printResponse.setBearingMin(printDrawing.getBearingMin());
		printResponse.setCust(printDrawing.getCust());
		printResponse.setCustPin(printDrawing.getCustPin());
		printResponse.setCustRev(printDrawing.getCustRev());
		printResponse.setDate(printDrawing.getDate());
		printResponse.setDateCreated(printDrawing.getDateCreated());
		printResponse.setDia1(printDrawing.getDia1());
		printResponse.setDia2(printDrawing.getDia2());
		printResponse.setDmgDrawingPath(printDrawing.getDwgPath());
		printResponse.setDrawingName(printDrawing.getDrawingName());
		printResponse.setFace1(printDrawing.getFace1()); // No change, Face1 maps to Face1
		printResponse.setOem(printDrawing.getOem());
		printResponse.setOriginatingCustomer(printDrawing.getOriginatingCustomer());
		printResponse.setPartNo(printDrawing.getPartNo());
		printResponse.setPdfPath(printDrawing.getPdfPath());
		printResponse.setPrevPartNo(printDrawing.getPrevPartNo());
		printResponse.setProductCode(printDrawing.getProductCode());
		printResponse.setRevNumber(printDrawing.getRevNumber());
		printResponse.setScannedPath(printDrawing.getScannedPath());
		printResponse.setSteps(printDrawing.getSteps());
		printResponse.setSubcontractor(printDrawing.getSubcontractor());
		printResponse.setType(printDrawing.getType());
		printResponse.setXlsmPath(printDrawing.getXlsmPath());
		printResponse.setXlsxPath(printDrawing.getXlsxPath());

		return printResponse;
	}

	// know the difference between a map and a for each
	@Override
	public PrintDrawingResponse getAllPrints(int pageNo, int pageSize) {

		// Pokemon pokemon3 = pokemonRepository.findById(333333)
		// .orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be foud by
		// ID"));

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<PrintDrawing> printList = printDrawingRepository.findAll(pageable);

		List<PrintDrawing> listOfPokemon = printList.getContent();

		List<PrintDrawingDto> content = new ArrayList<>();

		for (int i = 0; i < listOfPokemon.size(); i++) {

			content.add(mapToDto(listOfPokemon.get(i)));

		}

		PrintDrawingResponse printResponse = new PrintDrawingResponse();

		printResponse.setContent(content);
		printResponse.setPageSize(printList.getSize());
		printResponse.setTotalElements(printList.getTotalElements());
		printResponse.setTotalPages(printList.getTotalPages());
		printResponse.setLast(printList.isLast());

		return printResponse;

	}

	private PrintDrawingDto mapToDto(PrintDrawing printDrawing) {

		// copy created PrintDrawing to PrintDrawingDto Object
		PrintDrawingDto printDrawingDto = new PrintDrawingDto();

		// Transfer data from PrintDrawing to printDrawingDto
		printDrawingDto.setBearingMax(printDrawing.getBearingMax());
		printDrawingDto.setBearingMin(printDrawing.getBearingMin());
		printDrawingDto.setCust(printDrawing.getCust());
		printDrawingDto.setCustPin(printDrawing.getCustPin());
		printDrawingDto.setCustRev(printDrawing.getCustRev());
		printDrawingDto.setDate(printDrawing.getDate());
		printDrawingDto.setDateCreated(printDrawing.getDateCreated());
		printDrawingDto.setDia1(printDrawing.getDia1());
		printDrawingDto.setDia2(printDrawing.getDia2());
		printDrawingDto.setDmgDrawingPath(printDrawing.getDwgPath());
		printDrawingDto.setDrawingName(printDrawing.getDrawingName());
		printDrawingDto.setFace1(printDrawing.getFace1()); // No change, Face1 maps to Face1
		printDrawingDto.setOem(printDrawing.getOem());
		printDrawingDto.setOriginatingCustomer(printDrawing.getOriginatingCustomer());
		printDrawingDto.setPartNo(printDrawing.getPartNo());
		printDrawingDto.setPdfPath(printDrawing.getPdfPath());
		printDrawingDto.setPrevPartNo(printDrawing.getPrevPartNo());
		printDrawingDto.setProductCode(printDrawing.getProductCode());
		printDrawingDto.setRevNumber(printDrawing.getRevNumber());
		printDrawingDto.setScannedPath(printDrawing.getScannedPath());
		printDrawingDto.setSteps(printDrawing.getSteps());
		printDrawingDto.setSubcontractor(printDrawing.getSubcontractor());
		printDrawingDto.setType(printDrawing.getType());
		printDrawingDto.setXlsmPath(printDrawing.getXlsmPath());
		printDrawingDto.setXlsxPath(printDrawing.getXlsxPath());

		return printDrawingDto;

	}

	@Override
	public PrintDrawingDto getPrintById(int id) {

		PrintDrawing printDrawing = printDrawingRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be found"));

		// if (pokemonRepository.findById(id) != null) {
		// Pokemon pokemon = pokemonRepository.findById(id);
		// } else {
		// throw new PokemonNotFoundException("Pokemon could not be found);
		// }

		return mapToDto(printDrawing);
	}

	// never update that id
	@Override
	public PrintDrawingDto updatePrint(PrintDrawingDto printDrawingDto, int id) {
		// FIXME Auto-generated method stub

		PrintDrawing printDrawing = printDrawingRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be updated"));

		printDrawing.setBearingMax(printDrawingDto.getBearingMax());
		printDrawing.setBearingMin(printDrawingDto.getBearingMin());
		printDrawing.setCust(printDrawingDto.getCust());
		printDrawing.setCustPin(printDrawingDto.getCustPin());
		printDrawing.setCustRev(printDrawingDto.getCustRev());
		printDrawing.setDate(printDrawingDto.getDate());
		printDrawing.setDateCreated(printDrawingDto.getDateCreated());
		printDrawing.setDia1(printDrawingDto.getDia1());
		printDrawing.setDia2(printDrawingDto.getDia2());
		printDrawing.setDwgPath(printDrawingDto.getDmgDrawingPath());
		printDrawing.setDrawingName(printDrawingDto.getDrawingName());
		printDrawing.setFace1(printDrawingDto.getFace2());
		printDrawing.setOem(printDrawingDto.getOem());
		printDrawing.setOriginatingCustomer(printDrawingDto.getOriginatingCustomer());
		printDrawing.setPartNo(printDrawingDto.getPartNo());
		printDrawing.setPdfPath(printDrawingDto.getPdfPath());
		printDrawing.setPrevPartNo(printDrawingDto.getPrevPartNo());
		printDrawing.setProductCode(printDrawingDto.getProductCode());
		printDrawing.setRevNumber(printDrawingDto.getRevNumber());
		printDrawing.setScannedPath(printDrawingDto.getScannedPath());
		printDrawing.setSteps(printDrawingDto.getSteps());
		printDrawing.setType(printDrawingDto.getType());
		printDrawing.setSubcontractor(printDrawingDto.getSubcontractor());
		printDrawing.setType(printDrawingDto.getType());
		printDrawing.setXlsmPath(printDrawingDto.getXlsmPath());
		printDrawing.setXlsxPath(printDrawingDto.getXlsxPath());

		PrintDrawing updatedPrintDrawing = printDrawingRepository.save(printDrawing);

		return mapToDto(updatedPrintDrawing);

	}

	@Override
	public void deletePrintId(int id) {
		// FIXME Auto-generated method stub
		PrintDrawing printDrawing = printDrawingRepository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be deleted"));

		printDrawingRepository.delete(printDrawing);

	}

}
