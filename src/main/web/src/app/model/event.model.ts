import { Venue } from './venue.model';

export class Event {
  id:number;
  name:string;
  date:Date;
  venue:Venue = new Venue();
}
