package com.thoughtworks.glideappicondemo.module;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;

public class ApkIconLoader implements ModelLoader<String, Drawable> {
    private final Context context;

    public ApkIconLoader(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public LoadData<Drawable> buildLoadData(@NonNull String packageName, int width, int height, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(packageName), new ApkIconFetcher(context, packageName));
    }

    @Override
    public boolean handles(@NonNull String s) {
        return true;
    }
}
