import {NgTableComponent, NgTableSortingDirective} from 'ng2-table';
import {NgClass, CORE_DIRECTIVES} from '@angular/common';
import {Component, EventEmitter, Output} from '@angular/core';
import {BS_VIEW_PROVIDERS} from 'ng2-bootstrap';

@Component({
    selector: 'my-webhook-table',
    templateUrl: './webHookTable.component.html',
    viewProviders: [BS_VIEW_PROVIDERS],
    directives: [NgTableSortingDirective, NgClass, CORE_DIRECTIVES],
    outputs: ['showDetail']
})
export class WebHookTableComponent extends NgTableComponent {
    private showDetail: EventEmitter<any> = new EventEmitter<any>();

    public onShowDetail(row: any):void {
        this.showDetail.emit(row);
    }
}
