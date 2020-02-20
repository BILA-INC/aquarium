export class Animal {

  id: number;
  name: string;
  specy: string;
  sex: string;
  sign: string;
  arrivalDate: bigint;
  departureDate: string;

  constructor() {}

  setAttributes(id, name, specy, sex, sign, arrivalDate, departureDate) {
    this.id=id; this.name=name; this.specy=specy; this.sex=sex; this.sign=sign;
    this.arrivalDate=arrivalDate; this.departureDate=departureDate;
  }

}
