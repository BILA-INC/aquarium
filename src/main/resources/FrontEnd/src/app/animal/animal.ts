export class Animal {

  id: number;
  name: string;
  specy: string;
  gender: string;
  sign: string;
  arrivalDate: string;
  departureDate: string;

  constructor() {}

  setAttributes(id, name, specy, gender, sign, arrivalDate, departureDate) {
    this.id=id; this.name=name; this.specy=specy; this.gender=gender; this.sign=sign;
    this.arrivalDate=arrivalDate; this.departureDate=departureDate;
  }

}
