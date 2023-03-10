import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  id:number;
  book :Book= new Book();
  constructor(private bookService:BookService,
    private route:ActivatedRoute){}
  
  ngOnInit():void{
    this.id=this.route.snapshot.params['id'];
    this.bookService.getBookbyid(this.id).subscribe(data=>{
      this.book=data;
    },error=>console.log(error));
    
}
onSubmit(){

  this.bookService.updateBook(this.id,this.book).subscribe
  (data=>{
this.goToBooksList();
  }
  ,error => console.log(error));
    }

goToBookList()
{
  this.router.navigate(['/books']);
}
}