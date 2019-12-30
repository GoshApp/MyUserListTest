package com.goshapp.myuserlisttest.view.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.goshapp.myuserlisttest.R;
import com.goshapp.myuserlisttest.util.AnnotationUtil;
import com.goshapp.myuserlisttest.util.mvp.BaseView;
import butterknife.ButterKnife;

@SuppressWarnings("unchecked")
public abstract class AbsActivity<P extends AbsPresenter> extends AbsDaggerActivity<P>
        implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    @Override
    public void showError(String string, @Nullable Runnable runnable) {
        showError(R.string.error_occurred, string, runnable);
    }

    @Override
    public void showError(int string, @Nullable Runnable runnable) {
        showError(getString(string), runnable);
    }

    @Override
    public void showError(int title, int string, @Nullable Runnable runnable) {
        showError(title, getString(string), runnable);
    }

    @Override
    public void showNetworkError() {
        showError(getString(R.string.network_error));
    }



    private void setView() {
        int layoutId = AnnotationUtil.findViewId(this);
        if (layoutId != -1)
            setContentView(layoutId);
    }

}

