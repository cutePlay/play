import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DramasComponent} from './dramas/dramas.component';
import {DramaDetailComponent} from './drama-detail/drama-detail.component';

const routes: Routes = [
  { path: 'dramas', component: DramasComponent },
  { path: 'dramas/:id', component: DramaDetailComponent }
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
