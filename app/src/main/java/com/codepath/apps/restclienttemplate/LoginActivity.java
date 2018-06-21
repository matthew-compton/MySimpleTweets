package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.codepath.oauth.OAuthLoginActionBarActivity;

public class LoginActivity extends OAuthLoginActionBarActivity<TwitterClient> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, TimelineActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure(Exception e) {
        Log.d("TwitterClient", e.toString());
    }

    public void loginToRest(View view) {
        getClient().connect();
    }

}
