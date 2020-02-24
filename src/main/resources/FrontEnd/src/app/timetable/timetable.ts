export class Timetable {

  id: number;
  day: string;
  activity: string;
  startingHour: string;
  endingHour: string;

  constructor() {}

  setAttributes(id, day, activity, startingHour, endingHour) {
    this.id=id; this.day=day;
    this.activity=activity; this.startingHour=startingHour; this.endingHour=endingHour;
  }

}
