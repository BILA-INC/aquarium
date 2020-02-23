export class Pool {

  id: number;
  name: string;
  maxPopulation: number;
  maxVolume: number;
  isClean: string;
  zoneName: string;
  zoneLocalisation: string;
  activity: string;

  constructor() {}

  setAttributes(id, name, maxPopulation, maxVolume, isClean, zoneName, zoneLocalisation, activity) {
    this.id=id; this.name=name;
    this.maxPopulation=maxPopulation; this.maxVolume=maxVolume; this.isClean=isClean;
    this.zoneName=zoneName; this.zoneLocalisation=zoneLocalisation; this.activity=activity;
  }

}
