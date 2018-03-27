import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { JogadoresProvider } from '../../providers/jogadores/jogadores';
import { Jogador } from '../../model/jogador';


@IonicPage()
@Component({
  selector: 'page-jogador-detail',
  templateUrl: 'jogador-detail.html',
})
export class JogadorDetailPage {

  private id:number;
  jogador:Jogador;

  constructor(
    public navCtrl: NavController, public navParams: NavParams,
    private jogadorService:JogadoresProvider) {

     this.id =  this.navParams.get("id");

     this.jogador=new Jogador();
     this.jogadorService.lerJogador(this.id)
        .then (data=>{
            this.jogador.nome = data['nome'];
            this.jogador.id = data['id'];
            this.jogador.foto = data['foto'];
            console.log(this.jogador);
        });
  }
}


