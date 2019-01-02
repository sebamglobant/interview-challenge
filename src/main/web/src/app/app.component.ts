import { Component, OnInit } from '@angular/core';
import { VividseatsService } from './services/vividseats.service';
import { Event } from  '../app/model/event.model'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Vivid Seats Challenge';
  events:Event[];

  constructor(private vividseatsService: VividseatsService){}
  ngOnInit(): void {
    this.onGetEvents();
  }

  onGetEvents() {
    this.vividseatsService.getAllEvents().subscribe(
      (response: Event[]) => {
        console.log("response: ",response);
        this.events = response;
      },
      (error) => {
        console.log("error", error);
      }
    );
  }
}
