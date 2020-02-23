import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee/employee-details/employee-details.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import {EmployeeService} from "./employee/employee.service";
import { ConnexionInitComponent } from './connexion/connexion-init/connexion-init.component';
import { CreateAnimalComponent } from './animal/create-animal/create-animal.component';
import { AnimalListComponent } from './animal/animal-list/animal-list.component';
import { AnimalDetailsComponent } from './animal/animal-details/animal-details.component';
import { CreatePoolComponent } from './pool/create-pool/create-pool.component';
import { PoolDetailsComponent } from './pool/pool-details/pool-details.component';
import { PoolListComponent } from './pool/pool-list/pool-list.component';
import { CreateSpecyComponent } from './specy/create-specy/create-specy.component';
import { SpecyDetailsComponent } from './specy/specy-details/specy-details.component';
import { SpecyListComponent } from './specy/specy-list/specy-list.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ActivityDetailsComponent } from './activity/activity-details/activity-details.component';
import { ActivityListComponent } from './activity/activity-list/activity-list.component';
import { CreateActivityComponent } from './activity/create-activity/create-activity.component';

@NgModule({
  declarations: [
    AppComponent,

    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,

    ConnexionInitComponent,

    CreateAnimalComponent,
    AnimalListComponent,
    AnimalDetailsComponent,

    CreatePoolComponent,
    PoolDetailsComponent,
    PoolListComponent,

    CreateSpecyComponent,
    SpecyDetailsComponent,
    SpecyListComponent,

    AboutComponent,

    ContactComponent,

    ActivityDetailsComponent,
    ActivityListComponent,
    CreateActivityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule {}

