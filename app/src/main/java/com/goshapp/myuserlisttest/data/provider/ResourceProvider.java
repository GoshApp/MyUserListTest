package com.goshapp.myuserlisttest.data.provider;

import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;

public interface ResourceProvider {

    String getString(@StringRes int id);

    String getString(@StringRes int id, Object... objects);

    float getDimens(@DimenRes int id);
}
