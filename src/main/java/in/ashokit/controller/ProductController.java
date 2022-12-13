package in.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Product;
import in.ashokit.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		repo.save(product);
		return new ResponseEntity<>("Product Saved", HttpStatus.CREATED);
	}
	@PostMapping("/products")
	public ResponseEntity<String> addProducts(@RequestBody List<Product>  products){
		repo.saveAll(products);
		return new ResponseEntity<>("Multiple product saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> products = repo.findAll();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/product/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid){
		Product product = repo.findById(pid).get();
		System.out.println(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
		
		
	}
	

}
