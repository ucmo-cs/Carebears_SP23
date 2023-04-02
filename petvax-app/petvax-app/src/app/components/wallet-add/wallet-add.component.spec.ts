import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WalletAddComponent } from './wallet-add.component';

describe('WalletAddComponent', () => {
  let component: WalletAddComponent;
  let fixture: ComponentFixture<WalletAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WalletAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WalletAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
