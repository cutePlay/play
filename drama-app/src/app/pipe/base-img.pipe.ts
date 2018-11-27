import {Pipe, PipeTransform} from '@angular/core';
import {environment} from '../../environments/environment';

@Pipe({
  name: 'baseImg'
})
export class BaseImgPipe implements PipeTransform {

  transform(value: string, args?: any): any {
    return environment.baseImg + value;
  }

}
