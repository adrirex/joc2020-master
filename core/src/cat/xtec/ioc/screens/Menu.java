package cat.xtec.ioc.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import cat.xtec.ioc.SpaceRace;
import cat.xtec.ioc.helpers.AssetManager;
import cat.xtec.ioc.utils.Methods;
import cat.xtec.ioc.utils.Settings;


public class Menu extends BaseScreen {

    private Stage stage;

    private TextButton btnOri, btnAlt;
    private Label textLbl, textLbl2;


    public Menu(final SpaceRace game) {
        super(game);

        // Creem la càmera de les dimensions del joc
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        // Posant el paràmetre a true configurem la càmera per a
        // que faci servir el sistema de coordenades Y-Down
        camera.setToOrtho(true);

        // Creem el viewport amb les mateixes dimensions que la càmera
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT, camera);

        // Creem l'stage i assginem el viewport
        stage = new Stage(viewport);

        // Afegim el fons
        stage.addActor(new Image(AssetManager.background));

        // Creem l'estil de l'etiqueta i l'etiqueta
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = AssetManager.font;

        btnOri = new TextButton("NAVE ORIGINAL", style);

        // Creem el contenidor necessari per aplicar-li les accions
        Container container = new Container(btnOri);
        container.setTransform(true);
        container.center();
        container.setPosition(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 3);

        // Creem l'estil de l'etiqueta i l'etiqueta
        btnAlt = new TextButton("NAVE ALTERNATIVA", style);

        // Creem el contenidor necessari per aplicar-li les accions
        Container container2 = new Container(btnAlt);
        container2.setTransform(true);
        container2.center();
        container2.setPosition(Settings.GAME_WIDTH / 2, 175 / 2);

        stage.addActor(container);
        stage.addActor(container2);

        btnOri.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setNumNaves(1);
                game.create();
                game.setScreen(new GameScreen(stage.getBatch(), stage.getViewport(), game));
                dispose();
            }
        });

        btnAlt.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setNumNaves(2);
                game.create();
                game.setScreen(new GameScreen(stage.getBatch(), stage.getViewport(), game));
                dispose();
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        stage.draw();
        stage.act(delta);

        // Si es fa clic en la pantalla, canviem la pantalla
        /*if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(stage.getBatch(), stage.getViewport(), game));
            dispose();
        }*/

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

