package cat.xtec.ioc.screens;

import com.badlogic.gdx.Screen;

import cat.xtec.ioc.SpaceRace;


public abstract class BaseScreen implements Screen {

    protected SpaceRace game;

    public BaseScreen(SpaceRace game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
