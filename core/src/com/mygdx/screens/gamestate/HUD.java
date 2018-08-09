package com.mygdx.screens.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.AJGame;

import static com.badlogic.gdx.Gdx.app;

public class HUD {
	
	private GameWorld gameworld;
	private Viewport viewport;
	private Stage stage;
	private Skin skin;

	private Label scoreLabel, livesLabel, levelLabel, levelZahl;
	private Integer score = 0;
	private Integer level = 1;
	private Integer lifes = 3;
	private Table ingameTable;
	FreeTypeFontGenerator generator;



	public HUD(GameWorld gameworld) {
		this.gameworld = gameworld;
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(viewport, ((AJGame) app.getApplicationListener()).getBatch());
		skin = new Skin(Gdx.files.internal("uiskin.json"));





		createHUD();
	}


	public void dispose() {
		generator.dispose();
	}

	public void update(float delta) {
		stage.act(delta);
	}

	public void render() {
		stage.draw();
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	private void createHUD() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Angry Letter.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size= 50;
		BitmapFont ingameFont = generator.generateFont(parameter);
		ingameTable = new Table(skin);
		ingameTable.setFillParent(true);
		ingameTable.bottom();
		//scoreLabel = new Label(String.format("%06d", score), skin);
		//levelZahl = new Label(String.format("%2d", level), new Label.LabelStyle(ingameFont, Color.WHITE));
		levelLabel = new Label(String.format("Level  %02d", level), new Label.LabelStyle(ingameFont, Color.WHITE));
		livesLabel = new Label(String.format("  Lives  %01d", lifes), new Label.LabelStyle(ingameFont, Color.WHITE));
		scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(ingameFont, Color.WHITE));
		ingameTable.add(levelLabel).expandX().padTop(10);
		ingameTable.add(levelZahl).expandX().padTop(10);
		ingameTable.add(scoreLabel).expandX().padTop(10);
		ingameTable.add(livesLabel).expandX().padTop(10);
		stage.addActor(ingameTable);
	}

}
