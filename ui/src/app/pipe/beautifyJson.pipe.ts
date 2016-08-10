import {PipeTransform, Pipe} from "@angular/core";

@Pipe({name: 'beautifyJson'})
export class BeautifyJsonPipe implements PipeTransform {
    transform(value: string, args: any): any {
        return JSON.stringify(JSON.parse(value), null, 4);;
    }

}