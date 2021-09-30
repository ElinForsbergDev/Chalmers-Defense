package com.mygdx.chalmersdefense;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.chalmersdefense.controllers.MainScreenController;
import com.mygdx.chalmersdefense.model.Model;
import com.mygdx.chalmersdefense.views.GameScreen;
import com.mygdx.chalmersdefense.views.MainScreen;
import com.mygdx.chalmersdefense.views.ScreenEnum;
import com.mygdx.chalmersdefense.views.ScreenManager;

/**
 *  @author
 *
 *
 *  2021-09-16 Modified by Elin Forsberg: Added a timer to update Model
 *  2021-09-23 Modified by Joel Båtsman Hilmersson: Changed timer to use libGDX timer instead of javaswing
 */
public class ChalmersDefense extends Game {
	// The delay (ms) between when game data is being updated
	//private long delay = 5;
	private float delay = 0.005F;
	// The timer is started with a listener (see below) that executes the statements
	// Timer that calls method to update model
	private Timer timer;

	private Timer.Task task;

	private Music music;
	private Model model;



	@Override
	public void create() {
		model = new Model(this);
		timer = new Timer();
		createTask();

		// Creating Controllers
		MainScreenController mainScreenController = new MainScreenController();

		// Creating Views
		MainScreen mainScreen = new MainScreen(mainScreenController);
		GameScreen gameScreen = new GameScreen(model);

		// Init ScreenManager
		ScreenManager.getInstance().initialize(this, mainScreen, gameScreen);
		ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_MENU);


		music = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.wav"));
		music.setLooping(true);
		music.setVolume(0.2F);
		music.play();

	}

	private void createTask() {
		task = new Timer.Task() {
			@Override
			public void run() { if (task.isScheduled()) { model.updateModel();}
			}
		};
	}


	public int testJunit(int willDouble) {
		return willDouble * 2;
	}

	/**
	 * Stops the timer that updates model (Effectively pauses the game state)
	 */
	public void stopModelUpdate() {
		task.cancel();
		timer.stop();
		timer.clear();

		System.out.println("STOP TIMER");
	}

	/**
	 * Starts the timer that updates model (Effectively un-pauses the game)
	 */
	public void startModelUpdate() {
		setupTimer();
		System.out.println("START TIMER");
	}

	private void setupTimer() {
		createTask();
		timer.scheduleTask(task, 0, delay);
		timer.start();
	}

	/**
	 * Change model update speed to run simulation faster or slower
	 */
	public void changeUpdateSpeed() {
		if (delay < 0.004F){
			delay = 0.005F;
		} else {
			delay = 0.0028F;
		}
		timer.clear();
		setupTimer();
	}

	public boolean isUpdating(){
		return task.isScheduled();
	}

}
