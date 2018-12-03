import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {DramasComponent} from './dramas/dramas.component';
import {AppRoutingModule} from './app-routing.module';
import {BaseImgPipe} from './pipe/base-img.pipe';
import {DramaDetailComponent} from './dramas/drama-detail/drama-detail.component';
import {RolesComponent} from './dramas/roles/roles.component';
import {GameRoomComponent} from './game-room/game-room.component';
import {AuthInterceptor} from './interceptor/auth.interceptor';
import {RouteInterceptor} from './interceptor/route.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    DramasComponent,
    BaseImgPipe,
    DramaDetailComponent,
    RolesComponent,
    GameRoomComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }, RouteInterceptor],
  bootstrap: [AppComponent]
})
export class AppModule { }
