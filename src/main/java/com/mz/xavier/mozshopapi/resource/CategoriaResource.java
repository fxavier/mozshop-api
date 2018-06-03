package com.mz.xavier.mozshopapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mz.xavier.mozshopapi.event.RecursoCriadoEvent;
import com.mz.xavier.mozshopapi.model.Categoria;
import com.mz.xavier.mozshopapi.repository.CategoriaRepository;
import com.mz.xavier.mozshopapi.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoria.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> findById(@PathVariable Long codigo){
		Categoria categoriaSalva = categoriaRepository.findOne(codigo);
		
		return categoriaSalva != null ? ResponseEntity.ok(categoriaSalva) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> editar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria){
		Categoria categoriaActualizada = categoriaService.actualizar(codigo, categoria);
		
		return ResponseEntity.ok(categoriaActualizada);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		categoriaRepository.delete(codigo);
	}

}
