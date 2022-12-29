import { OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../book';
import { Component } from '@angular/core';
import { BookService } from '../book.service';
@Component({
  selector: 'app-bookdetail',
  templateUrl: './bookdetail.component.html',
  styleUrls: ['./bookdetail.component.css']
})
export class BookdetailComponent implements OnInit {
  id:number
  book:Book
  constructor(private route:ActivatedRoute,private bookService:BookService){}
    ngOnInit():void{
      this.id=this.route.snapshot.params['id'];
      this.book=new Book();
      this.bookService.getBookbyid(this.id).subscribe(data=>{this.book=data;
      });
    }
  }


