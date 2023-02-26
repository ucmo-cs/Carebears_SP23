import { Component, Input } from '@angular/core';
import { empty } from 'rxjs';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss']
})
export class PetComponent {
  @Input() petName: string | undefined;
  @Input() petImg: string | undefined;
}