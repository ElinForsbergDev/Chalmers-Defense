package com.mygdx.chalmersdefense.utilities;

import com.badlogic.gdx.utils.Timer;
import com.mygdx.chalmersdefense.model.IUpdateModel;

/**
 * @author Joel Båtsman Hilmersson
 * <p>
 * A class containing metods related to the game timer. Wraps a timer object in it
 * The timer then calls update method in the given model
 */
public class GameTimer {
    private final Timer timer = new Timer();    // The timer object
    private Timer.Task task = new Timer.Task() {
        @Override
        public void run() {}
    }; // The runnable task the timer uses to schedule method calls with
    private float delay = 0.005F;               // Delay in seconds between task calls
    private final IUpdateModel model;           // The model to update

    /**
     * Constructor for the GameTimer class
     *
     * @param model The class to update continuously
     */
    public GameTimer(IUpdateModel model) {
        this.model = model;
    }

    /**
     * Starts the timer that updates model (Effectively un-pauses the game)
     */
    public void startUpdateTimer() {
        setupTask();
        timer.start();
    }

    /**
     * Stops the timer that updates model (Effectively pauses the game state)
     */
    public void stopUpdateTimer() {
        task.cancel();  // Cancels current task so the update method won't be called
        timer.stop();   // Stops timer
        timer.clear();  // Clears timer from old tasks
    }

    /**
     * Change model update speed to run simulation faster or slower based on current speed
     */
    public void changeUpdateSpeed() {
        if (delay < 0.004F) {
            delay = 0.005F;
        } else {
            delay = 0.0028F;
        }
        timer.clear();  // Resets timer task list
        setupTask();
    }

    // Creates new task with current delay
    private void setupTask() {
        task = new Timer.Task() {
            @Override
            public void run() {
                if (task.isScheduled()) {
                    model.updateModel();
                }
            }
        };
        timer.scheduleTask(task, 0, delay);
    }
}
