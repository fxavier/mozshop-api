package com.mz.xavier.mozshopapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mz.xavier.mozshopapi.model.Produto;
import com.mz.xavier.mozshopapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto actualizar(Produto produto, Long codigo) {
		Produto produtoActualizado = produtoRepository.getOne(codigo);
		if(produtoActualizado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(produto, produtoActualizado, "codigo");
		return produtoRepository.save(produtoActualizado);
	}

}
