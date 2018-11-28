import {DramaScene} from './drama-scene';
import {DramaInfo} from './drama-info';

export class GameRoom {
  id: number;
  dramaId: number;
  sceneFlag: number;
  scenes: DramaScene[];
  infos: DramaInfo[];
}
