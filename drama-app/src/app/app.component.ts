import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {CookieStorage, LocalStorage} from 'ngx-store';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = '超可爱玩~剧本杀';
  @LocalStorage() @CookieStorage({key: 'userId'}) userId = '';
  constructor(private route: ActivatedRoute) {}
  ngOnInit(): void {
    this.route.queryParams.subscribe((param: Params) => {
      if (param['openid']) {
        this.userId = param['openid'];
      } else {
        console.info('no openid');
      }
    }

    );
  }
}

