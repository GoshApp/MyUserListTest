package com.goshapp.myuserlisttest.util.viewextention;


import android.support.annotation.StringRes;

import com.thefintechlab.whitelabelandroid.R;
import com.thefintechlab.whitelabelandroid.util.rx.ServerError;

import javax.annotation.Nullable;

public interface ErrorView {

    default void showError(ServerError serverError) {
        if (serverError.hasTitleAndMessage()) {
            showError(serverError.getTitle(), serverError.getMessage());
        } else if (serverError.hasOnlyMessage()) {
            showError(serverError.getMessage());
        } else if (serverError.hasOnlyRaw()) {
            showError(serverError.getRawMessage());
        } else {
            showError(R.string.unexpected_error);
        }
    }

    default void showError(String string) {
        showError(string, null);
    }

    default void showError(@StringRes int string) {
        showError(string, null);
    }

    default void showError(@StringRes Integer title, String string) {
        showError(title, string, null);
    }

    void showError(@StringRes int title, String string, @Nullable Runnable runnable);

    default void showError(@StringRes int title, @StringRes int message) {
        showError(title, message, null);
    }

    void showError(@StringRes int title, @StringRes int string, @Nullable Runnable runnable);

    void showError(String string, @Nullable Runnable runnable);

    void showError(@StringRes int string, @Nullable Runnable runnable);

    void showNetworkError();

    void showTimeOutError();

    void showSessionTimeout();

}
