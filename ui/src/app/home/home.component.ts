import {Component, OnInit, ViewChild, ElementRef} from '@angular/core';
import {CORE_DIRECTIVES, NgIf, NgClass} from '@angular/common';
import {PAGINATION_DIRECTIVES, ModalDirective, MODAL_DIRECTIVES} from 'ng2-bootstrap/ng2-bootstrap';
import {NG_TABLE_DIRECTIVES} from 'ng2-table';
import {Http, URLSearchParams, RequestOptions} from '@angular/http';
import {FORM_DIRECTIVES} from '@angular/forms';
import {WebHookTableComponent} from './table/webHookTable.component';
import {WebHook} from '../model/WebHook';
import {BeautifyJsonPipe} from '../pipe/beautifyJson.pipe';

@Component({
    selector: 'my-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss'],
    directives: [MODAL_DIRECTIVES, NG_TABLE_DIRECTIVES, PAGINATION_DIRECTIVES, CORE_DIRECTIVES,
        FORM_DIRECTIVES, WebHookTableComponent, NgClass, NgIf],
    pipes: [BeautifyJsonPipe]
})
export class HomeComponent implements OnInit {
    public columns: Array<any> = [
        {title: 'Date', name: 'insertDate'},
        {title: 'Email', name: 'email'},
        {title: 'Type', name: 'type'},
        {title: 'Send', name: 'sendId'}
    ];

    @ViewChild('childModal')
    public childModal: ModalDirective;

    public rows: Array<WebHook> = [];
    public page: number = 1;
    public itemsPerPage: number = 20;
    public length: number = 0;
    public maxSize: number = 5;
    public activeWebHook: WebHook;
    public json: string = "";

    public config: any = {
        paging: true
    };

    constructor(private http: Http, private el: ElementRef) {
    }

    ngOnInit() {
        this.onChangeTable(this.config);
    }

    public onChangeTable(config: any, page: any = {page: this.page, itemsPerPage: this.itemsPerPage}): any {
        this.http.get('/record', new RequestOptions({search: new URLSearchParams(`page=${this.page - 1}&size=${this.itemsPerPage}&sort=insertDate:DESC`)}))
            .map(res => res.json())
            .subscribe(data => {
                    //noinspection TypeScriptUnresolvedVariable
                    console.log(data.totalElements);
                    this.rows = data.content;
                    //noinspection TypeScriptUnresolvedVariable
                    this.length = data.totalElements;
                },
                err => console.log(err),
                () => console.log('Completed')
            );
    }

    public onShowDetail(webHook: WebHook): any {
        this.activeWebHook = webHook;
        this.childModal.show();
    }
}
