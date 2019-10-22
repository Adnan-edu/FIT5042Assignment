import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Heritages} from './model/heritages.model';
import {Heritagegroups} from './model/heritagegroups.model';
import {Architecturalstyle} from './model/architecturalstyle.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  APIURL = "http://localhost:8080/WebSecuredApp/webresources/fit5042.restful.heritage/search";
  HGRPAPIURL = "http://localhost:8080/WebSecuredApp/webresources/fit5042.restful.heritagegroup/heritagegroups";
  ARCHAPIURL = "http://localhost:8080/WebSecuredApp/webresources/fit5042.restful.architecturalstyle/architecturalstyles";
  ALLHERITAGEAPIURL = "http://localhost:8080/WebSecuredApp/webresources/fit5042.restful.heritage/fetchAllHeritages";
  constructor(private _http: HttpClient) { }
  getHeritages(groupId, archId){
    var updated_url = this.APIURL + "/" + groupId + "/" + archId;
    return this._http.get<Heritages[]>(updated_url,{ responseType: 'json'});
  }
  getHeritageGroups(){
    return this._http.get<Heritagegroups[]>(this.HGRPAPIURL,{ responseType: 'json'});
  }
  getArchStyles(){
    return this._http.get<Architecturalstyle[]>(this.ARCHAPIURL,{ responseType: 'json'});
  }
  getAllHeritages(){
    return this._http.get<Heritages[]>(this.ALLHERITAGEAPIURL,{ responseType: 'json'});
  }
}
