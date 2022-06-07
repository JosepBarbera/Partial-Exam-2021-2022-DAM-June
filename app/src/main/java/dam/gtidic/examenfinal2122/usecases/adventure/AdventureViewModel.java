package dam.gtidic.examenfinal2122.usecases.adventure;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class AdventureViewModel  extends ViewModel{

    private MutableLiveData<Integer> lives;
    private AdventureActivity adventureActivity;


    public AdventureViewModel(){
        this.lives = new MutableLiveData<>();

    }

    public void purchaseLives(){
        int actual_lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        actual_lives +=1;
        PreferencesProvider.providePreferences().edit().putInt("lives", actual_lives).commit();
        this.lives.setValue(actual_lives);
    }

    public MutableLiveData<Integer> getLives() {
        return lives;
    }

    public void setLives(MutableLiveData<Integer> lives) {
        this.lives = lives;
    }

    public AdventureActivity getAdventureActivity() {
        return adventureActivity;
    }

    public void setAdventureActivity(AdventureActivity adventureActivity) {
        this.adventureActivity = adventureActivity;
    }
}
