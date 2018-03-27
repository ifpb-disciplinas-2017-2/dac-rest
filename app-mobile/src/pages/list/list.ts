import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { JogadoresProvider } from '../../providers/jogadores/jogadores';
import { Jogador } from '../../model/jogador';

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {
  
  private jogadores:any;
  
  constructor(
    public navCtrl: NavController, public navParams: NavParams, 
    private jogadorService:JogadoresProvider) {
    
      jogadorService.todosOsJogadores()
      .then(data=>{
        this.jogadores = data;
      });
  }

  ionViewDidEnter(){
    this.jogadorService.todosOsJogadores()
      .then(data=>{
        this.jogadores = data;
      });
  }
  remover(jogador:Jogador){
    this.jogadorService.removerJogador(jogador.id)
      .then(data=>{
        let index = this.jogadores.indexOf(jogador);
        this.jogadores.splice(index,1);
      });
  }
  editarJogador(jogador:Jogador){
    this.navCtrl.push('JogadorEditPage', {jogador:jogador});
  }

  irParaJogador(id:number){
      this.navCtrl.push('JogadorDetailPage',{id:id});
  }
  novoJogador(){
      this.navCtrl.push('JogadorEditPage');
  }
  

   
}
