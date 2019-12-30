package com.goshapp.myuserlisttest.data.provider;

import android.content.Context;

public class ResourceProviderImpl implements ResourceProvider {
    private Context context;

    public ResourceProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getString(int id) {
        return context.getString(id);
    }

    @Override
    public String getString(int id, Object... objects) {
        return context.getString(id, objects);
    }

    @Override
    public float getDimens(int id) {
        return context.getResources().getDimension(id);
    }
}
