import {Component, OnInit} from '@angular/core';
import {RoleService} from '../../service/role.service';
import {Role} from '../../core/role';
import {ActivatedRoute} from '@angular/router';
import {Page} from '../../core/page';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent implements OnInit {
  roles: Page<Role>;
  constructor(private roleService: RoleService,
              private routes: ActivatedRoute) { }

  ngOnInit() {
    this.getRoles();
  }

  getRoles() {
    const id = +this.routes.snapshot.parent.paramMap.get('id');
    this.roleService.getRoles(id)
      .subscribe(roles => this.roles = roles);
  }
}
