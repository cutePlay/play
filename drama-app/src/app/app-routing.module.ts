import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DramasComponent} from './dramas/dramas.component';

const routes: Routes = [
  { path: 'dramas', component: DramasComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
