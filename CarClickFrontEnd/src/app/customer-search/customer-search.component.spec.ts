import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientSearchComponent } from './customer-search.component';

describe('CustomerSearchComponent', () => {
  let component: ClientSearchComponent;
  let fixture: ComponentFixture<ClientSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
