package net.javaguider.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguider.demo.model.book;
import net.javaguider.demo.repository.bookrepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200/")
public class bookcontroller {
	@Autowired
private bookrepository bkr;
	
	//get all book this will return all book to client
	
	//select* from bookinformation
	@GetMapping("/books")
	public List<book>getallbooks()
	{
		return bkr.findAll();
		
	}


//create book rest api
@PostMapping("/books")
public book createbook(@RequestBody book bk)
{
return bkr.save(bk);	
}

//get book by id
@GetMapping("/books/{id}")
public ResponseEntity<book> getBookbyid(@PathVariable Long id) throws Exception
{
	 book obj = bkr.findById(id)
			 .orElseThrow(() -> new Exception("not found"+id));
	 return ResponseEntity.ok(obj);
}

//update book rest api
@PutMapping("/books/{id}")
public ResponseEntity<book> updateBook(@PathVariable Long id,@RequestBody book objdetails) throws Exception
{
 book obj = bkr.findById(id)
		 .orElseThrow(() -> new Exception("not found"+id));
	
	
	obj.setBookname(objdetails.getBookname());
	obj.setId(objdetails.getId());
	obj.setEmailId(objdetails.getEmailId());
	obj.setAuthor(objdetails.getAuthor());
	obj.setEmailId(objdetails.getEmailId());
	obj.setCategory(objdetails.getCategory());
	book updatedBook=bkr.save(obj);
	return ResponseEntity.ok(updatedBook);
	
	
	}










//delete book
@DeleteMapping("/books/{id}")
public ResponseEntity<Map<String, Boolean>> deletebook(@PathVariable Long id) throws Exception{
book obj = bkr.findById(id)
			 .orElseThrow(() -> new Exception("not found"+id));
	bkr.delete(obj);
	Map<String,Boolean>response=new HashMap<>();
	response.put("deleted",Boolean.TRUE);
	return ResponseEntity.ok(response);
}
}
