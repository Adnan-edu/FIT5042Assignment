import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeritagelistComponent } from './heritagelist.component';

describe('HeritagelistComponent', () => {
  let component: HeritagelistComponent;
  let fixture: ComponentFixture<HeritagelistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeritagelistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeritagelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
