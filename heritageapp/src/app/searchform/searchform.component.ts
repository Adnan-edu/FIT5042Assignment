import {Component, Input, OnInit} from '@angular/core';
import {Heritages} from '../model/heritages.model';
import {DataService} from '../data.service';
import {Heritagegroups} from '../model/heritagegroups.model';
import {Architecturalstyle} from '../model/architecturalstyle.model';

@Component({
  selector: 'app-searchform',
  templateUrl: './searchform.component.html',
  styleUrls: ['./searchform.component.css']
})
export class SearchformComponent implements OnInit {
  heritagesList: Heritages[];
  heritagegroups: Heritagegroups[];
  architecturalstyles: Architecturalstyle[];
  selectedGroup: number;
  selectedStyleId: number
  heritageId: string;
  archId: string;
  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.heritagesList = null;
    this.dataService.getHeritageGroups().subscribe(data => this.heritagegroups = data);
    this.dataService.getArchStyles().subscribe(data => this.architecturalstyles = data);
  }
  fetchData(){
    if(this.selectedGroup != null && this.selectedStyleId!=null){
      console.log('Is Clicked OPtions ' + this.selectedGroup);
      var groupIdNew = this.selectedGroup;
      var archIdNew = this.selectedStyleId;
      return this.dataService.getHeritages(groupIdNew, archIdNew).subscribe(data => this.heritagesList = data);
    }else{
      console.log("No item is selected");
    }
  }
  fetchAllHeritageData(){
    return this.dataService.getAllHeritages().subscribe(data => this.heritagesList = data);
  }
}
