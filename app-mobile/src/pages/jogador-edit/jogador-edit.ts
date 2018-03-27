import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Jogador } from '../../model/jogador';
import { JogadoresProvider } from '../../providers/jogadores/jogadores';

/**
 * Generated class for the JogadorEditPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-jogador-edit',
  templateUrl: 'jogador-edit.html',
})
export class JogadorEditPage {

  jogador:Jogador;

  constructor(
    public navCtrl: NavController, public navParams: NavParams
      ,private jogadorService:JogadoresProvider) {

     if(this.navParams.data.jogador){
        this.jogador = this.navParams.data.jogador;
     } else{  
      this.jogador = new Jogador();
    }

  }

 salvar(){
   if(this.jogador.id){
       this.jogadorService.atualizar(this.jogador)
       .then(data=>this.navCtrl.pop());
  }else{this.jogadorService.salvar(this.jogador)
      .then(data=>this.navCtrl.pop());
  }
 }

}
