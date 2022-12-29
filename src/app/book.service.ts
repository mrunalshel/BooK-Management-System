import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn:'root' 
})
export class BookService {
  
 private baseURL= "http://localhost:8080/api/v1/books";
  
  constructor(public httpClient:HttpClient) { }
  getBooksList():Observable<Book[]>
  {
    return this.httpClient.get<Book[]>(`${this.baseURL}`);
  }

  createBook(book:Book):Observable<any>
  {
  return this.httpClient.post(`${this.baseURL}`,book);
  }
  getBookbyid(id:number):Observable<Book>
  {
    return this.httpClient.get <Book[]>(`${this.baseURL}`);
  }
  updateBook(book:Book):Observable<any>
  {
  return this.httpClient.post(`${this.baseURL}`,book);
  }
  deleteBook(id:number):Observable<any>
  {
  return this.httpClient.delete(`${this.baseURL}/$(id)`);
  }

}
