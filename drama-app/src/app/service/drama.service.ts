import {Injectable} from '@angular/core';
import {Drama} from '../core/drama';
import {Page} from '../core/page';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class DramaService {
  private url = environment.baseApi + '/api/dramas';
  constructor(private http: HttpClient) {
  }

  getDramas(): Observable<Page<Drama>> {
    return this.http.get<Page<Drama>>(this.url)
      .pipe(
        catchError(this.handleError<Page<Drama>>('getDramas', new Page<Drama>()))
      );
  }
  getDrama(id: number): Observable<Drama> {
    const url = `${this.url}/${id}`;
    return this.http.get<Drama>(url)
      .pipe(
        catchError(this.handleError<Drama>('getDramas', new Drama()))
      );
  }
  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      // this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
