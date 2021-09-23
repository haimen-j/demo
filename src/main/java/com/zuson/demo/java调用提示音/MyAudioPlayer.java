package com.zuson.demo.java调用提示音;

import org.springframework.util.ResourceUtils;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

class MyAudioPlayer {
    private URL url = null; // 音乐文件的URl
    private AudioStream audioStream = null; // 播放器
    public MyAudioPlayer() {
        try {
      File file =
          ResourceUtils.getFile(
              "classpath:template/tips.wav");
            url = file.toURI().toURL();
            InputStream inputStream = url.openStream(); // 获得音乐文件的输入流
            audioStream = new AudioStream(inputStream);
            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用AudioPlayer静态成员player.start播放音乐
     */
    public void play() {
        AudioPlayer.player.start(audioStream);
    }
    /**
     * 用AudioPlayer静态成员player.start播放音乐
     */
    public void stop() {
        AudioPlayer.player.stop(audioStream);
    }

    public static void main(String[] args) {
        new MyAudioPlayer().play();
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        new MyAudioPlayer().stop();
    }
}
