package com.goshapp.myuserlisttest.util.mvp.viewextention;


import androidx.annotation.StringRes;

public interface MessageView {

    void showToast(@StringRes int id);

    void showToast(String message);

}
