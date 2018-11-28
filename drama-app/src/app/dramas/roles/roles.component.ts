import {Component, OnInit} from '@angular/core';
import {Role} from '../../core/role';
import {ActivatedRoute} from '@angular/router';
import {Page} from '../../core/page';
import {DramaService} from '../../service/drama.service';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent implements OnInit {
  roles: Page<Role>;
  constructor(private dramaService: DramaService,
              private routes: ActivatedRoute) { }

  ngOnInit() {
    this.getRoles();
  }

  getRoles() {
    const id = +this.routes.snapshot.parent.paramMap.get('id');
    this.dramaService.getRoles(id)
      .subscribe(roles => this.roles = roles);
  }
}
