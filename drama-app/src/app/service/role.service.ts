import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {environment} from '../../environments/environment';
import {Observable, of} from 'rxjs';
import {Page} from '../core/page';
import {Role} from '../core/role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private url = environment.baseApi + '/api/dramas';
  constructor(private http: HttpClient) {
  }

  getRoles(dramaId: number): Observable<Page<Role>> {
    const url = `${this.url}/${dramaId}/roles`;
    return this.http.get<Page<Role>>(url)
    .pipe(
      catchError(this.handleError<Page<Role>>('getRoles', new Page<Role>()))
    );
  }
  getRole(id: number): Observable<Role> {
    const url = `${this.url}/${id}`;
    return this.http.get<Role>(url)
    .pipe(
      catchError(this.handleError<Role>('getDramas', new Role()))
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
