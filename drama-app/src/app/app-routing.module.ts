import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DramasComponent} from './dramas/dramas.component';
import {DramaDetailComponent} from './dramas/drama-detail/drama-detail.component';
import {RolesComponent} from './dramas/roles/roles.component';
import {GameRoomComponent} from './game-room/game-room.component';

const routes: Routes = [
  {
    path: 'dramas',
    children: [
      {
        path: '',
        component: DramasComponent,
      },
      {
        path: ':id',
        component: DramaDetailComponent,
        children: [
          {
            path: 'roles',
            component: RolesComponent
          }
        ]
      }
    ]
  },
  {
    path: 'gameRooms/:id',
    component: GameRoomComponent
  }
  // { path: 'dramas/:id', component: DramaDetailComponent },
  // { path: 'dramas/:id/roles', component: RolesComponent }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
