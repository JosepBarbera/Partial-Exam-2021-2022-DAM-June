package dam.gtidic.examenfinal2122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import dam.gtidic.examenfinal2122.usecases.adventure.AdventureActivity;
import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), " -> onCreate()");
        setup();
        data();
    }

    // Private methods
    private void setup(){
        Log.d(this.getClass().getSimpleName(), " -> setup()");
        Log.d(this.getClass().getSimpleName(), " ... init Shared Preferences()");
        PreferencesProvider.init(this);
        Date currentTime = Calendar.getInstance().getTime();

       // if(isSameDay(currentTime, ))
        PreferencesProvider.providePreferences().edit().putInt("lives", 0).commit();
    }


    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH)
                == calendar2.get(Calendar.DAY_OF_MONTH);
    }

    private void data(){
        showHome();
        finish();
    }

    private void showHome(){
        startActivity(new Intent(this, AdventureActivity.class));
    }

}