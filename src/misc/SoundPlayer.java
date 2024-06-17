package src.misc;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;



public class SoundPlayer {

  public static String whooshPath = "C:\\Users\\jacks\\Downloads\\fast-whoosh-118248.wav";
  public static String chachingPath = "C:\\Users\\jacks\\Downloads\\cash-register-purchase-87313.wav";

  private String filePath;
  private Thread soundThread;

  public SoundPlayer(String filePath) {
    this.filePath = filePath;
    this.soundThread = new Thread(this::playSound);
  }

  public void play() {
    soundThread.start();
  }

  private void playSound() {
    Clip clip = null;
    try {
      File soundFile = new File(filePath);
      if (!soundFile.exists()) {
        System.err.println("Sound file not found: " + filePath);
        return;
      }

      System.out.println("File found. Getting audio input stream...");
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

      System.out.println("Audio input stream obtained. Getting clip...");
      clip = AudioSystem.getClip();

      System.out.println("Clip obtained. Opening audio stream...");
      clip.open(audioIn);

      CountDownLatch latch = new CountDownLatch(1);

      clip.addLineListener(event -> {
        if (event.getType() == LineEvent.Type.STOP) {
          latch.countDown();
          System.out.println("Playback completed.");
        }
      });

      System.out.println("Playing sound...");
      clip.start();

      // Wait for the clip to finish playing
      latch.await();

      System.out.println("Sound played successfully.");

    } catch (UnsupportedAudioFileException e) {
      System.err.println("Unsupported audio file: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("I/O error: " + e.getMessage());
    } catch (LineUnavailableException e) {
      System.err.println("Line unavailable: " + e.getMessage());
    } catch (InterruptedException e) {
      System.err.println("Playback interrupted: " + e.getMessage());
    } finally {
      if (clip != null && clip.isOpen()) {
        clip.close();
      }
    }
  }
}
