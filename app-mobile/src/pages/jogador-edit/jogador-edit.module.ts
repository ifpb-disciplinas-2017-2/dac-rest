import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { JogadorEditPage } from './jogador-edit';

@NgModule({
  declarations: [
    JogadorEditPage,
  ],
  imports: [
    IonicPageModule.forChild(JogadorEditPage),
  ],
})
export class JogadorEditPageModule {}
