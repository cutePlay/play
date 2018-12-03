import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CookieStorage, LocalStorage} from 'ngx-store';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  @LocalStorage() @CookieStorage({key: 'userId'}) userId;
  constructor() {
  }
  intercept (req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.info('header ', this.userId);
    const authReq = req.clone({
      headers: req.headers.set('openId', this.userId)
    });
    return next.handle(authReq);
  }


}
