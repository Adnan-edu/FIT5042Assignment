import {Component, Input, OnInit} from '@angular/core';
import {Heritages} from '../model/heritages.model';
import {DataService} from '../data.service';

@Component({
  selector: 'app-searchform',
  templateUrl: './searchform.component.html',
  styleUrls: ['./searchform.component.css']
})
export class SearchformComponent implements OnInit {
  heritagesList: Heritages[];
  heritageId: string;
  archId: string;
  constructor(private dataService: DataService) { }

  ngOnInit() {
  }
  fetchData(){
    console.log('Is Clicked HeritageId ' + this.heritageId + '.ArchitecturalId ' + this.archId);
    var groupIdNew = parseInt(this.heritageId);
    var archIdNew = parseInt(this.archId);
    return this.dataService.getHeritages(groupIdNew, archIdNew).subscribe(data => this.heritagesList = data);
  }
}
