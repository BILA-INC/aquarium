export class Employee {
  id: number;
  firstName: string;
  lastName: string;
  address: string;

  setAttributes(id, firstName, lastName, address) {
     this.id=id; this.firstName=firstName; this.lastName=lastName; this.address=address;
  }
}
