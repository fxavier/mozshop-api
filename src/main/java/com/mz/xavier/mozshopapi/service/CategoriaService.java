package com.mz.xavier.mozshopapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mz.xavier.mozshopapi.model.Categoria;
import com.mz.xavier.mozshopapi.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria actualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.findOne(codigo);
		if(categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		return categoriaRepository.save(categoriaSalva);
	}

}
