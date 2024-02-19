import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {MatRadioModule} from '@angular/material/radio';

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [
    FormsModule, 
    ReactiveFormsModule, 
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatRadioModule],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.scss'
})
export class AuthComponent {
  isRegister=true;

  registrationForm= new FormGroup({
      fullName: new FormControl("",[Validators.required]),
      email: new FormControl("",[Validators.required,Validators.email]),
      password: new FormControl("",[Validators.required,Validators.minLength(6)]),

  });

  loginForm= new FormGroup({
    email: new FormControl("",[Validators.required,Validators.email]),
    password: new FormControl("",[Validators.required]),

});

  handleRegister(){
    console.log("register", this.registrationForm.value);
  }

  handleLogin(){
    console.log("login", this.loginForm.value);
  }

  togglePanel(){
    this.isRegister=!this.isRegister;
  }


}
