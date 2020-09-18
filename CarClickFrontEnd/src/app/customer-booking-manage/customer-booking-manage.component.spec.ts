import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerBookingManageComponent } from './customer-booking-manage.component';

describe('ClientBookingManageComponent', () => {
  let component: CustomerBookingManageComponent;
  let fixture: ComponentFixture<CustomerBookingManageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerBookingManageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerBookingManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
