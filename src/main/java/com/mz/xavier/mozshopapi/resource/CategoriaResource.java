package com.mz.xavier.mozshopapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.xavier.mozshopapi.event.CreatedResourceEvent;
import com.mz.xavier.mozshopapi.model.Categoria;
import com.mz.xavier.mozshopapi.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new CreatedResourceEvent(this, response, categoria.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
		
	}

}
