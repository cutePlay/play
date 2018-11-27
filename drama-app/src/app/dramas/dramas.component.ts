import {Component, OnInit} from '@angular/core';
import {Drama} from '../core/drama';
import {DramaService} from '../service/drama.service';
import {Page} from '../core/page';

@Component({
  selector: 'app-dramas',
  templateUrl: './dramas.component.html',
  styleUrls: ['./dramas.component.css']
})
export class DramasComponent implements OnInit {
  dramas: Page<Drama> = new Page();
  constructor(private dramaService: DramaService) {
  }

  ngOnInit() {
    this.getDramas();
  }

  getDramas(): void {
    this.dramaService.getDramas()
      .subscribe(dramas => {
        this.dramas = dramas;
      });
  }

}
