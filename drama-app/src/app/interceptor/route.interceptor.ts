import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {CookieStorage, LocalStorage} from 'ngx-store';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';

@Injectable()
export class RouteInterceptor implements CanActivate {
  @LocalStorage() @CookieStorage({key: 'userId'}) userId;
  constructor(private router: Router) {}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):
    Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (!this.userId) {
      console.info('redirect');
      window.location.href = 'http://localhost:8088/api/wx/authorize/redirect';
      return false;
    }
    console.info('route', this.userId);
    return true;
  }

}
