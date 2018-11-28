import {Component, OnInit} from '@angular/core';
import {GameRoom} from '../core/game-room';
import {GameRoomService} from '../service/game-room.service';
import {ActivatedRoute} from '@angular/router';
import {DramaService} from '../service/drama.service';

@Component({
  selector: 'app-game-room',
  templateUrl: './game-room.component.html',
  styleUrls: ['./game-room.component.css']
})
export class GameRoomComponent implements OnInit {
  gameRoom: GameRoom;
  id: number;
  constructor(private gameRoomService: GameRoomService,
              private dramaService: DramaService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.getGameRoom();
  }

  getGameRoom() {
    this.gameRoomService.getGameRoom(this.id)
      .subscribe(room => {
        this.gameRoom = room;
      });
  }


}
