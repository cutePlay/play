import {Component, OnInit} from '@angular/core';
import {Drama} from '../core/drama';
import {DramaService} from '../service/drama.service';
import {Page} from '../core/page';
import {ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'app-dramas',
  templateUrl: './dramas.component.html',
  styleUrls: ['./dramas.component.css']
})
export class DramasComponent implements OnInit {
  dramas: Page<Drama>;
  constructor(private dramaService: DramaService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParams.subscribe((param: Params) =>
      console.info(param)
    );
    this.getDramas();
  }

  getDramas(): void {
    this.dramaService.getDramas()
      .subscribe(dramas => {
        this.dramas = dramas;
      });
  }

}
