
package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public class GlideConfiguration extends AppGlideModule {
    public GlideConfiguration() {
        super();
        Log.d("GlideConfiguration", ">>>>>>> GlideConfiguration");
    }

    @Override
    public void applyOptions(@NonNull Context context,
                             @NonNull GlideBuilder builder) {
        Log.d("GlideConfiguration", ">>>>>>> applyOptions");
        super.applyOptions(context, builder);
    }

    @Override
    public void registerComponents(@NonNull Context context,
                                   @NonNull Glide glide,
                                   @NonNull Registry registry) {

        Log.d("GlideConfiguration", ">>>>>>> registerComponents");
        super.registerComponents(context, glide, registry);
        MyApp.getComponent(context).inject(this);
    }

//    private ApplicationComponent getApplicationComponent(Context context) {
//        return context.getApplicationContext();
//    }
}
