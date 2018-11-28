import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {DramasComponent} from './dramas/dramas.component';
import {AppRoutingModule} from './app-routing.module';
import {BaseImgPipe} from './pipe/base-img.pipe';
import {DramaDetailComponent} from './dramas/drama-detail/drama-detail.component';
import {RolesComponent} from './dramas/roles/roles.component';

@NgModule({
  declarations: [
    AppComponent,
    DramasComponent,
    BaseImgPipe,
    DramaDetailComponent,
    RolesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
