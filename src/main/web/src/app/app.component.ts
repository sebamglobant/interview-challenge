import { Component, OnInit } from '@angular/core';
import { ProjectService } from './services/project.service';
import { Event } from  '../app/model/event.model'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Interview Challenge';
  events:Event[] = [];
  states:any[];

  constructor(private projectService: ProjectService){}

  ngOnInit(): void {
    this.onGetEvents();
    this.populateStates();
  }

  onGetEvents() {
    this.projectService.getAllEvents().subscribe(
      (response: Event[]) => {
        this.events = response;
      },
      (error) => {
        console.log("error", error);
      }
    );
  }

  onSubmitEvent(eventForm: NgForm) {

    if(eventForm.valid) {
      let event = new Event();
      event.name = eventForm.value.eventName;
      event.date = new Date(
        eventForm.value.eventDate.year,
        eventForm.value.eventDate.month,
        eventForm.value.eventDate.day);
      event.venue.name = eventForm.value.venueName;
      event.venue.city = eventForm.value.eventCity;
      event.venue.state = eventForm.value.eventState;

      this.onAddEvent(event)
    }
  }

  onAddEvent(event: Event) {
    this.projectService.insertEvent(event).subscribe(
      (response) => {
        if(response) {
          this.onGetEvents();
        }
      },
      (error) => {
        console.log("error",error)
      }
    );
  }

  populateStates() {
    this.states = [
      "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
      "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
      "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
      "VA", "WA", "WV", "WI", "WY",
    ]
  }

}
