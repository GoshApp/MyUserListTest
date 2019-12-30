package com.goshapp.myuserlisttest.util;


import androidx.annotation.LayoutRes;
import androidx.annotation.MenuRes;

import com.goshapp.myuserlisttest.util.annotation.CloseToolbarBehavior;
import com.goshapp.myuserlisttest.util.annotation.DefaultToolbarBehavior;
import com.goshapp.myuserlisttest.util.annotation.HasKeyboard;
import com.goshapp.myuserlisttest.util.annotation.RequiresMenu;
import com.goshapp.myuserlisttest.util.annotation.RequiresView;
import com.goshapp.myuserlisttest.util.mvp.BasePresenter;
import com.goshapp.myuserlisttest.util.mvp.annotation.RequiresPresenter;

public class AnnotationUtil {

    public static Class<? extends BasePresenter> findPresenterClass(Object object) {
        return ((RequiresPresenter) object.getClass().getAnnotation(RequiresPresenter.class)).value();
    }

    public static @LayoutRes
    int findViewId(Object object) {
        if (object.getClass().isAnnotationPresent(RequiresView.class))
            return object.getClass().getAnnotation(RequiresView.class).value();
        else
            return -1;
    }

    public static @MenuRes
    int findMenuId(Object object) {
        if (object.getClass().isAnnotationPresent(RequiresMenu.class))
            return object.getClass().getAnnotation(RequiresMenu.class).value();
        else
            return -1;
    }

    public static boolean hasKeyboard(Object object) {
        return object.getClass().isAnnotationPresent(HasKeyboard.class);
    }

    public static boolean hasPresenter(Object object) {
        return object.getClass().isAnnotationPresent(RequiresPresenter.class);
    }

    public static boolean hasDefaultToolbarBehavior(Object object) {
        return object.getClass().isAnnotationPresent(DefaultToolbarBehavior.class);
    }

    public static boolean hasCloseToolbarBehavior(Object object) {
        return object.getClass().isAnnotationPresent(CloseToolbarBehavior.class);
    }
}

