import { Component, OnInit } from '@angular/core';
import {Heritages} from '../model/heritages.model';

@Component({
  selector: 'app-heritagelist',
  templateUrl: './heritagelist.component.html',
  styleUrls: ['./heritagelist.component.css']
})
export class HeritagelistComponent implements OnInit {
  heritages: Heritages[] = [];
  constructor() { }

  ngOnInit() {
  }

}
