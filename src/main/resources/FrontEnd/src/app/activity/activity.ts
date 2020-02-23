export class Activity {

  id: number;
  day: string;
  startingHour: string;
  endingHour: string;
  publicPrivate: string;
  name: string;

  constructor() {}

  setAttributes(id, day, startingHour, endingHour, publicPrivate, name) {
    this.id=id; this.day=day;
    this.startingHour=startingHour; this.endingHour=endingHour; this.publicPrivate=publicPrivate; this.name=name;
  }

}
