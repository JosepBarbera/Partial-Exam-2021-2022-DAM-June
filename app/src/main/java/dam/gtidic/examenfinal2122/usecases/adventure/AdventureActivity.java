package dam.gtidic.examenfinal2122.usecases.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import dam.gtidic.examenfinal2122.R;
import dam.gtidic.examenfinal2122.databinding.ActivityAdventureBinding;
import dam.gtidic.examenfinal2122.databinding.ActivityGameBinding;
import dam.gtidic.examenfinal2122.usecases.game.GameViewModel;
import dam.gtidic.examenfinal2122.usecases.game.math.GameActivityMath;

public class AdventureActivity extends AppCompatActivity {

    private AdventureViewModel adventureViewModel;
    private GameViewModel gameViewModel;
    private ActivityAdventureBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);
        setup();
        data();

        adventureViewModel.lives.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
            }
        });
    }




    // Private methods
    private void setup(){
        binding = ActivityAdventureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adventureViewModel = new ViewModelProvider(this).get(AdventureViewModel.class);
        binding.setAdventureViewModel(adventureViewModel);
        //gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        //binding.setGameViewModel(gameViewModel);
        binding.setLifecycleOwner(this);


        this.getOnBackPressedDispatcher()
                .addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                close();
            }
        });
    }

    private void data(){
        Log.d(this.getClass().getSimpleName(),"...data() ");
    }

    public void showMathAdventure(View view){
            startActivity( new Intent(this, GameActivityMath.class));
    }


    private void close(){
        Log.d(this.getClass().getSimpleName(), "...closing()");
        finishAffinity();
    }

}