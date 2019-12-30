package com.goshapp.myuserlisttest.util.viewextention;

import android.support.annotation.StringRes;

public interface MessageView {

    void showToast(@StringRes int id);

    void showToast(String message);

}
