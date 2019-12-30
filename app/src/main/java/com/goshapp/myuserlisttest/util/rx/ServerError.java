package com.goshapp.myuserlisttest.util.rx;

import android.text.TextUtils;
import androidx.annotation.StringRes;

public class ServerError {
    private int title = 0;
    private int message = 0;
    private String rawMessage = "";
    private String messageArgs;

    private ServerError(@StringRes int title, @StringRes int message) {
        this.title = title;
        this.message = message;
    }

    public ServerError(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public static ServerError from(@StringRes int message) {
        return new ServerError(0, message);
    }

    public static ServerError from(@StringRes int title, @StringRes int message) {
        return new ServerError(title, message);
    }

    public static ServerError raw(String message) {
        return new ServerError(message);
    }

    @StringRes
    public int getTitle() {
        return title;
    }

    @StringRes
    public int getMessage() {
        return message;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public String getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(String messageArgs) {
        this.messageArgs = messageArgs;
    }

    public boolean hasOnlyRaw() {
        return title == 0
                && message == 0
                && !TextUtils.isEmpty(rawMessage);
    }

    public boolean hasOnlyMessage() {
        return title == 0 && message != 0;
    }

    public boolean hasTitleAndMessage() {
        return title != 0 && message != 0;
    }
}
