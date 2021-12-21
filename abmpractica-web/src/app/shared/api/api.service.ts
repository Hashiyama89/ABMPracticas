import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';


const API_ENDPOINT = 'http://localhost:8080/abmpractica-api/'


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }


  invocar(endpoint, params = {}): Observable<any> {
	try {
		const url = API_ENDPOINT + endpoint

		console.log("INVOCANDO API", url, params)

		return this.http.post(url, params)

	} catch (error) {
		console.log("ERROR AL INVOCAR ", endpoint)
		throw error
	}

  }
}
