import {Component, OnInit} from '@angular/core';
import {DataService} from './data.service';
import {Heritages} from './model/heritages.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'heritageapp';

  constructor(){}
  ngOnInit(){

  }

}
