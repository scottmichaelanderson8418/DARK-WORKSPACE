/**
 * 
 */
package com.pokemonreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemonreview.model.PrintDrawing;



@Repository
public interface PrintDrawingRespository extends JpaRepository<PrintDrawing, Integer> {

}
