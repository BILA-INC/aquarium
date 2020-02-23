export class Employee {

  id: number;
  firstName: string;
  lastName: string;
  birthdate: string;
  address: string;
  secuNum: bigint;
  password: string;
  position: string; pool: string; zone: string; activity: string;

  constructor() {}

  setAttributes(id, firstName, lastName, birthdate, address, secuNum, password,
                position, pool, zone, activity) {
     this.id=id; this.firstName=firstName; this.lastName=lastName; this.birthdate=birthdate; this.address=address;
     this.secuNum=secuNum; this.password=password;
     this.position=position; this.pool=pool; this.zone=zone; this.activity=activity;
  }

}
