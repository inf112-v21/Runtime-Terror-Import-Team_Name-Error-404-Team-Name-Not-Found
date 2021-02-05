package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandling {
    /**
     * Check relevant keys for input
     */
    public void checkInputs(){
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            isEnter();
        }
    }

    /**
     * Key event functions
     */
    public void isEnter(){

    }
}
