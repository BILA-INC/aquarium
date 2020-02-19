export class Employee {

  id: number;
  firstName: string;
  lastName: string;
  birthdate: string;
  address: string;
  secuNum: bigint;
  password: string;

  constructor() {}

  setAttributes(id, firstName, lastName, birthdate, address, secuNum, password) {
     this.id=id; this.firstName=firstName; this.lastName=lastName; this.birthdate=birthdate; this.address=address;
     this.secuNum=secuNum; this.password=password;
  }

}
