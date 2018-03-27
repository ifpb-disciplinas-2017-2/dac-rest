import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import { Jogador } from '../../model/jogador';

@Injectable()
export class JogadoresProvider {

  private data:any;
  private obj:any;

  constructor(public http: Http) {
    console.log('Hello JogadoresProvider Provider');
  }

  todosOsJogadores(){
    return new Promise(resolve =>{
      this.http.get('http://localhost:8080/dac-jogador/api/jogador')
      .map(result => result.json())
        .subscribe(data => {
          this.data = data;
          resolve(this.data);
        });
      });
  }
  
  lerJogador(id:number){
    return new Promise(resolve =>{
      this.http.get('http://localhost:8080/dac-jogador/api/jogador/'+id)
      .map(result => result.json())
        .subscribe(data => {
          this.obj = data;
          resolve(this.obj);
        });
      });
  }
  removerJogador(id:number){
    return new Promise(resolve =>{
      this.http.delete('http://localhost:8080/dac-jogador/api/jogador/'+id)
      .map(result => result.json())
        .subscribe(data => {
          this.obj = data;
          resolve(this.obj);
        });
      });
  }
  salvar(jogador:Jogador){
    return new Promise(resolve =>{
      this.http.post('http://localhost:8080/dac-jogador/api/jogador/', jogador)
      .map(result => result.json())
        .subscribe(data => {
          this.obj = data;
          resolve(this.obj);
        });
      });
  }
  atualizar(jogador:Jogador){
    return new Promise(resolve =>{
      this.http.put('http://localhost:8080/dac-jogador/api/jogador/'+jogador.id, jogador)
      .map(result => result.json())
        .subscribe(data => {
          this.obj = data;
          resolve(this.obj);
        });
      });
  }
}
