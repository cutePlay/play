import {Component, OnInit} from '@angular/core';
import {DramaService} from '../service/drama.service';
import {ActivatedRoute} from '@angular/router';
import {Drama} from '../core/drama';

@Component({
  selector: 'app-drama-detail',
  templateUrl: './drama-detail.component.html',
  styleUrls: ['./drama-detail.component.css']
})
export class DramaDetailComponent implements OnInit {
  drama: Drama;
  constructor(private dramaService: DramaService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDrama();
  }

  getDrama(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.dramaService.getDrama(id)
      .subscribe(drama => this.drama = drama);
  }
}
