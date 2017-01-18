package insa.com.ptitchef.IntroActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro2;

import insa.com.ptitchef.LoginActivity;

public class IntroActivity extends AppIntro2 {

    private final IntroActivity activity = this;

    @Override
    public void init(Bundle bundle) {
        // Adding fragments
        addSlide(new SlideFragment1(), getApplicationContext());
        addSlide(new SlideFragment2(), getApplicationContext());

        setFadeAnimation();
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(activity, LoginActivity.class));
        activity.finish();
    }

}
