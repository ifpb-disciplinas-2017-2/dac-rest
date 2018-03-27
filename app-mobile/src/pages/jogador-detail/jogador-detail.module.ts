import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { JogadorDetailPage } from './jogador-detail';

@NgModule({
  declarations: [
    JogadorDetailPage,
  ],
  imports: [
    IonicPageModule.forChild(JogadorDetailPage),
  ],
})
export class JogadorDetailPageModule {}
