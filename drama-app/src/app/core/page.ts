export class Page<T> {
  current: number;
  size: number;
  total: number;
  records: T[];
  constructor() {
    this.records = [];
  }
}
