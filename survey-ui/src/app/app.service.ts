import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/index';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  constructor(private http: HttpClient) {
  }

  getSurvey(surveyId) {
    console.log('service');
    return this.http.get(`/api/v1/surveys?surveyId=${surveyId}`);
  }
}
