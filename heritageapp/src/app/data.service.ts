import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Heritages} from './model/heritages.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  APIURL = "http://localhost:8080/WebSecuredApp/webresources/fit5042.restful.heritage/search";
  constructor(private _http: HttpClient) { }
  getHeritages(groupId, archId){
    // tslint:disable-next-line:prefer-const
    console.log('Is Clicked ---> HeritageId ' + groupId + '.ArchitecturalId ' + archId);
    var updated_url = this.APIURL + "/" + groupId + "/" + archId;
    return this._http.get<Heritages[]>(updated_url,{ responseType: 'json'});
  }
}
