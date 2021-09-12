package com.mygdx.chalmersdefense;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

public class Launcher extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite virus;
	Sprite virus2;
	Sprite virus3;
	Sprite virus4;
	Music music;
	TextureRegion backgroundTexture;
	Camera camera;
	Viewport viewport;


	private final Vector2 rotHelper= new Vector2();

	@Override
	public void create () {
		camera = new OrthographicCamera(1920, 1080);
		viewport = new FitViewport(camera.viewportWidth, camera.viewportHeight, camera);
		viewport.setCamera(camera);
		batch = new SpriteBatch();
		img = new Texture("HomeScreen.png");




		virus = new Sprite(new Texture("corona_virus_low.png"));
		virus2 = new Sprite(new Texture("corona_virus_low.png"));
		virus3 = new Sprite(new Texture("corona_virus_low.png"));
		virus4 = new Sprite(new Texture("corona_virus_low.png"));

		virus.setPosition(-300, -150);	// This needs to be fixed with later sprites
		virus.setScale(0.15F);					// This too

		virus2.setPosition(50, -150);	// This needs to be fixed with later sprites
		virus2.setScale(0.15F);					// This too

		virus3.setPosition(-300, 40);	// This needs to be fixed with later sprites
		virus3.setScale(0.15F);					// This too

		virus4.setPosition(50, 40);	// This needs to be fixed with later sprites
		virus4.setScale(0.15F);					// This too


		music = Gdx.audio.newMusic(Gdx.files.internal("ponggamesound.wav"));

		music.setLooping(true);
		music.setVolume((float) 0.2);
		music.play();

		Gdx.graphics.setWindowedMode(1920, 1080); // Sets the width and height of the program window
	}

	@Override
	public void render () {
		camera.update();
		ScreenUtils.clear(255, 255, 255, 1);

		batch.setProjectionMatrix(camera.combined); // Renders based on window pixels and not screen pixels.

		batch.begin();
		batch.draw(img, 0, 0, viewport.getWorldWidth(),viewport.getWorldHeight());

		virus.draw(batch);
		virus2.draw(batch);
		virus3.draw(batch);
		virus4.draw(batch);

		virus.setRotation(getAngle(Gdx.input.getX(), Gdx.input.getY(), 300, 600));
		virus2.setRotation(getAngle(Gdx.input.getX(), Gdx.input.getY(), 1000, 600));
		virus3.setRotation(getAngle(Gdx.input.getX(), Gdx.input.getY(), 300, 240));
		virus4.setRotation(getAngle(Gdx.input.getX(), Gdx.input.getY(), 1000, 240));
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		music.dispose();
	}


	//rotToX/Y is the coordinates to be rotated to, orgX/Y is the location to be rotated around
	private float getAngle(int rotToX, int rotToY, int orgX, int orgY){
		rotHelper.set(rotToX - orgX, rotToY - orgY);
		return -rotHelper.angleDeg();	// Negative because it just works then :)
	}

	public int testJunit(int willDouble){
		return willDouble * 2;
	}

}
