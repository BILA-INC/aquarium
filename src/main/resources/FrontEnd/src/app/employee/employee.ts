export class Employee {

  id: number;
  firstName: string;
  lastName: string;
  birthdate: string;
  address: string;
  secuNum: bigint;

  setAttributes(id, firstName, lastName, birthdate, address, secuNum) {
     this.id=id; this.firstName=firstName; this.lastName=lastName; this.birthdate=birthdate; this.address=address;
     this.secuNum=secuNum;
  }
}
