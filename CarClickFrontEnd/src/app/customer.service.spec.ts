import { TestBed } from '@angular/core/testing';

import { ClientService } from './customer.service';
import { Client } 

describe('CustomerService', () => {
  let service: ClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
