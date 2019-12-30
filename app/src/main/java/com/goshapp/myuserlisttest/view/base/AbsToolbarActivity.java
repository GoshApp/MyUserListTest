package com.goshapp.myuserlisttest.view.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;

import com.goshapp.myuserlisttest.R;
import com.goshapp.myuserlisttest.util.AnnotationUtil;

import butterknife.BindView;

public abstract class AbsToolbarActivity<P extends AbsPresenter> extends AbsActivity<P> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("3333");

        if (AnnotationUtil.hasDefaultToolbarBehavior(this))
            setNavigation(R.drawable.ic_arrow_back_black_24dp, v -> onBackPressed());
        else if (AnnotationUtil.hasCloseToolbarBehavior(this))
            setNavigation(R.drawable.ic_close_black_24dp, v -> onBackPressed());
    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void setTitle(@StringRes int id) {
        getSupportActionBar().setTitle(id);
    }

    public void setSubtitle(String title) {
        getSupportActionBar().setSubtitle(title);
    }

    public void setSubtitle(@StringRes int id) {
        getSupportActionBar().setSubtitle(id);
    }

    public void clearNavigation() {
        toolbar.setNavigationIcon(null);
    }

    public void setNavigation(@DrawableRes int id) {
        toolbar.setNavigationIcon(id);
    }

    public void setNavigation(@DrawableRes int id, View.OnClickListener clickListener) {
        toolbar.setNavigationIcon(id);
        toolbar.setNavigationOnClickListener(clickListener);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int menuId = AnnotationUtil.findMenuId(this);
        if (menuId != -1)
            getMenuInflater().inflate(menuId, menu);
        this.menu = menu;
        onOptionsMenuInflated(menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onOptionsMenuInflated(Menu menu) {
    }

    public void hideOption(int id) {
        if (menu == null)
            return;
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

    public void showOption(int id) {
        if (menu == null)
            return;
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }

    public void setOptionTitle(int id, String title) {
        if (menu == null)
            return;
        MenuItem item = menu.findItem(id);
        item.setTitle(title);
    }

    public void setOptionIcon(int id, int iconRes) {
        if (menu == null)
            return;
        MenuItem item = menu.findItem(id);
        item.setIcon(iconRes);
    }

    public Menu getMenu() {
        return menu;
    }
}
