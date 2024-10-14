package com.pokemonreview.service;

import com.pokemonreview.dto.PrintDrawingDto;
import com.pokemonreview.dto.PrintDrawingResponse;

//Pokemon Service is another layer of abstraction from the repository
public interface PrintDrawingService {

	PrintDrawingDto createPrint(PrintDrawingDto printDto);

	PrintDrawingResponse getAllPrints(int pageNo, int pageSize);

	PrintDrawingDto getPrintById(int id);

	PrintDrawingDto updatePrint(PrintDrawingDto printDrawingDto, int id);

	void deletePrintId(int id);

}
