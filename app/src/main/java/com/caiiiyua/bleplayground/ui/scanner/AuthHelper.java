package com.caiiiyua.bleplayground.ui.scanner;

import android.content.Context;
import android.content.Intent;

import com.caiiiyua.bleplayground.R;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.FirebaseApp;

import java.util.Arrays;

/**
 * Created by pp on 5/02/17.
 */
public class AuthHelper {
    public static Intent getAuthUiIntent(Context applicationContext) {
        Intent i = AuthUI.getInstance(FirebaseApp.initializeApp(applicationContext))
                .createSignInIntentBuilder()
                .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                .setTheme(R.style.LoginTheme)
                .setLogo(R.drawable.logo)
                .build();
        return i;
    }
}
