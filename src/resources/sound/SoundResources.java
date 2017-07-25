
package resources.sound;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

import resources.Resources;

public class SoundResources
{

    AudioInputStream audio;

    public SoundResources()
    {
        try {
            audio = AudioSystem.getAudioInputStream(Resources.getResourceAsStream("sounds/1.wav"));
            Clip c = AudioSystem.getClip();
            System.out.println(audio);
            c.open(audio);
            c.start();
            try {
                System.out.println("gonna sleep");
                Thread.sleep(2000);
                System.out.println("sleept");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.close();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        SoundResources r = new SoundResources();
    }

}
