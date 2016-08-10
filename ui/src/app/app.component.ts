import {Component, ViewContainerRef} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router';
import {BS_VIEW_PROVIDERS} from 'ng2-bootstrap';

import {ApiService} from './shared';

import '../style/app.scss';
import '../style/sb-admin-2.css';

/*
 * App Component
 * Top Level Component
 */
@Component({
    selector: 'my-app', // <my-app></my-app>
    providers: [ApiService],
    directives: [...ROUTER_DIRECTIVES],
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    viewProviders: [BS_VIEW_PROVIDERS]
})
export class AppComponent {
    url = 'https://github.com/preboot/angular2-webpack';

    constructor(private api: ApiService, private viewContainerRef: ViewContainerRef) {
    }
}
