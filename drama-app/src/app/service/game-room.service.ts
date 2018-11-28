import {Injectable} from '@angular/core';
import {GameRoom} from '../core/game-room';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GameRoomService {
  private url = environment.baseApi + '/api/gameRooms';
  constructor(private http: HttpClient) { }
  getGameRoom(id: number): Observable<GameRoom> {
    const url = `${this.url}/${id}`;
    return this.http.get<GameRoom>(url)
      .pipe(catchError(this.handleError<GameRoom>('room', new GameRoom())));
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
