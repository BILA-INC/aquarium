export class Pool {

  id: number;
  maxPopulation: number;
  maxVolume: number;
  isClean: string;
  zoneName: string;
  zoneLocalisation: string;

  constructor() {}

  setAttributes(id, maxPopulation, maxVolume, isClean, zoneName, zoneLocalisation) {
    this.id=id; this.maxPopulation=maxPopulation; this.maxVolume=maxVolume; this.isClean=isClean;
    this.zoneName=zoneName; this.zoneLocalisation=zoneLocalisation;
  }

}
