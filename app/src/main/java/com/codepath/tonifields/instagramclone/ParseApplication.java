package com.codepath.tonifields.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("6k588zUMou5MRyD88ecG1apXfUlEIh2HcjKtY8jG")
                .clientKey("AADi482Vdi8VcBe8jesgZ3b90gjNVtfojqzSa7oy")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
