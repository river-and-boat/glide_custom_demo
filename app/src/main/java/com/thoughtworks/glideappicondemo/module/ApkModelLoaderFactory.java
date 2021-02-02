package com.thoughtworks.glideappicondemo.module;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

public class ApkModelLoaderFactory implements ModelLoaderFactory<String, Drawable> {
    private final Context context;

    public ApkModelLoaderFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ModelLoader<String, Drawable> build(@NonNull MultiModelLoaderFactory multiFactory) {
        return new ApkIconLoader(context);
    }

    @Override
    public void teardown() {

    }
}
