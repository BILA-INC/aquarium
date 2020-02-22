export class Specy {

  id: number;
  name: string;
  diet: string;
  lifeExpectancy: number;
  isEndangered: string;
  dangerLevel: string;

  constructor() {}

  setAttributes(id, name, diet, lifeExpectancy, isEndangered, dangerLevel) {
    this.id=id; this.name=name; this.diet=diet; this.lifeExpectancy=lifeExpectancy; this.isEndangered=isEndangered;
    this.dangerLevel=dangerLevel;
  }

}
