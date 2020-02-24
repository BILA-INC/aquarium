import { EmployeeDetailsComponent } from './employee/employee-details/employee-details.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { ConnexionInitComponent} from './connexion/connexion-init/connexion-init.component';
import {AnimalListComponent} from "./animal/animal-list/animal-list.component";
import {CreateAnimalComponent} from "./animal/create-animal/create-animal.component";
import {AnimalDetailsComponent} from "./animal/animal-details/animal-details.component";
import {SpecyListComponent} from "./specy/specy-list/specy-list.component";
import {CreateSpecyComponent} from "./specy/create-specy/create-specy.component";
import {SpecyDetailsComponent} from "./specy/specy-details/specy-details.component";
import {PoolListComponent} from "./pool/pool-list/pool-list.component";
import {CreatePoolComponent} from "./pool/create-pool/create-pool.component";
import {PoolDetailsComponent} from "./pool/pool-details/pool-details.component";
import {AboutComponent} from "./about/about.component";
import {ContactComponent} from "./contact/contact.component";
import {ActivityListComponent} from "./activity/activity-list/activity-list.component";
import {CreateActivityComponent} from "./activity/create-activity/create-activity.component";
import {ActivityDetailsComponent} from "./activity/activity-details/activity-details.component";
import {CreateTimetableComponent} from "./timetable/create-timetable/create-timetable.component";
import {TimetableListComponent} from "./timetable/timetable-list/timetable-list.component";
import {TimetableDetailsComponent} from "./timetable/timetable-details/timetable-details.component";

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },

  { path: 'all/employee', component: EmployeeListComponent },
  { path: 'add/employee', component: CreateEmployeeComponent },
  { path: 'update/employee', component: UpdateEmployeeComponent },
  { path: 'details/employee/:id', component: EmployeeDetailsComponent },

  { path: 'connexion', component: ConnexionInitComponent },

  { path: 'all/animal', component: AnimalListComponent },
  { path: 'add/animal', component: CreateAnimalComponent },
  { path: 'details/animal/:id', component: AnimalDetailsComponent },

  { path: 'all/specy', component: SpecyListComponent },
  { path: 'add/specy', component: CreateSpecyComponent },
  { path: 'details/specy/:id', component: SpecyDetailsComponent },

  { path: 'all/pool', component: PoolListComponent },
  { path: 'add/pool', component: CreatePoolComponent },
  { path: 'details/pool/:id', component: PoolDetailsComponent },

  { path: 'all/activity', component: ActivityListComponent },
  { path: 'add/activity', component: CreateActivityComponent },
  { path: 'details/activity/:id', component: ActivityDetailsComponent },

  { path: 'all/timetable', component: TimetableListComponent },
  { path: 'add/timetable', component: CreateTimetableComponent },
  { path: 'details/timetable/:id', component: TimetableDetailsComponent },

  { path: 'about', component: AboutComponent },

  { path: 'contact', component: ContactComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
