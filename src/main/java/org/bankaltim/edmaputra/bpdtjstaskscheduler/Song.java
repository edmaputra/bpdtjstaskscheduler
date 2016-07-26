package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.io.File;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class Song {	

	SoundJLayer soundToPlay;
	
	public Song(){
	}
	
	public void startPlayBack(String path) {
		soundToPlay = new SoundJLayer(path);
		soundToPlay.play();
	}
	
	public void stopPlayBack(){
//		soundToPlay.playbackFinished(new PlaybackEvent(null, null, null));
		soundToPlay.stop();
	}
}

class SoundJLayer extends PlaybackListener implements Runnable {
	private String filePath;
	private AdvancedPlayer player;
	private Thread playerThread;

	public SoundJLayer(String filePath) {
		this.filePath = filePath;
	}

	public void play() {
		try {
			String urlAsString = "file:///" + new File(filePath).getCanonicalPath();
			
			this.player = new AdvancedPlayer(new java.net.URL(urlAsString).openStream(),
					javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());

			this.player.setPlayBackListener(this);

			this.playerThread = new Thread(this, "AudioPlayerThread");

			this.playerThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void stop(){
		this.player.stop();		
	}

	// PlaybackListener members

	public void playbackStarted(PlaybackEvent playbackEvent)
    {
        System.out.println("playbackStarted");
    }

	public void playbackFinished(PlaybackEvent playbackEvent)
    {
        System.out.println("playbackEnded");        
    }

	// Runnable members

	public void run() {
		try {
			this.player.play();
		} catch (javazoom.jl.decoder.JavaLayerException ex) {
			ex.printStackTrace();
		}
	}
}
