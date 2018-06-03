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
import org.springframework.web.bind.annotation.RestController;

import com.mz.xavier.mozshopapi.event.RecursoCriadoEvent;
import com.mz.xavier.mozshopapi.model.Produto;
import com.mz.xavier.mozshopapi.repository.ProdutoRepository;
import com.mz.xavier.mozshopapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository  produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> findById(@PathVariable Long codigo){
		Produto produtoAchado = produtoRepository.getOne(codigo);
		return produtoAchado != null ? ResponseEntity.ok(produtoAchado) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response){
		Produto produtoSalvo = produtoRepository.save(produto);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> editar(@PathVariable Long codigo, Produto produto){
		Produto produtoEditado = produtoService.actualizar(produto, codigo);
		return ResponseEntity.ok(produtoEditado);
	}
	
	@DeleteMapping("/{codigo}")
	public void deletar(@PathVariable Long codigo) {
		produtoRepository.delete(codigo);
	}

}
