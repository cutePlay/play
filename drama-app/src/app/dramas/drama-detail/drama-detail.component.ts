import {Component, OnInit} from '@angular/core';
import {DramaService} from '../../service/drama.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Drama} from '../../core/drama';

@Component({
  selector: 'app-drama-detail',
  templateUrl: './drama-detail.component.html',
  styleUrls: ['./drama-detail.component.css']
})
export class DramaDetailComponent implements OnInit {
  drama: Drama;
  id: number;
  constructor(private dramaService: DramaService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.getDrama();
  }

  getDrama(): void {
    this.dramaService.getDrama(this.id)
      .subscribe(drama => this.drama = drama);
  }
  start(): void {
    this.dramaService.newGame(this.id)
      .subscribe(id => {
        console.info(id);
        this.router.navigate(['/gameRooms', id])
          .catch(err => console.error(err));
      });
    // console.info('开始游戏');
  }
}
