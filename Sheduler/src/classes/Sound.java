/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author admin
 */
public class Sound implements Runnable{
    String bip = "C:\\sound.mp3";
    MediaPlayer mediaPlayer;
    public Sound (){
    final JFXPanel fxPanel = new JFXPanel();
            
            
    }

    @Override
    public void run() {
        while (true){
        try {
            Media hit = new Media(new File(bip).toURI().toString());
            mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
   }

