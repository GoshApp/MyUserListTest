package com.goshapp.myuserlisttest.view.base;


import com.goshapp.myuserlisttest.util.mvp.BasePresenter;
import com.goshapp.myuserlisttest.util.mvp.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

@SuppressWarnings("WeakerAccess")
public abstract class AbsPresenter<V extends BaseView> implements BasePresenter <V> {

    public V view;
    private List <Disposable> disposables = new ArrayList <>();
    private List <Disposable> subjectDisposables = new ArrayList <>();
    private List <BindObservable> bindObservables = new ArrayList <>();

    @Override
    public void bindView(V view) {
        this.view = view;
        notifyOnBinded();
    }

    @Override
    public void onCreate(V view) {
        this.view = view;
        notifyOnBinded();
    }

    /**
     * Only for fragment
     *
     * @param view
     */
    @Override
    public void onVisible(V view) {
        this.view = view;
        notifyOnBinded();
    }

    @Override
    public void onCleanup() {
        dispose();
        disposeSubjects();
    }

    @Override
    public void unbindView() {
        this.view = null;
        disposeSubjects();
    }

    public void add(Disposable disposable) {
        disposables.add(disposable);
    }

    public void addOnBind(Disposable disposable) {
        subscribeOnBind(new BindObservable() {
            @Override
            public void onBinded(BindObservable it) {
                disposables.add(disposable);
            }
        });
    }

    @Override
    public void subscribeOnBind(BindObservable bindObservable) {
        if (isBinded()) {
            bindObservable.onBinded(bindObservable);
        } else {
            bindObservables.add(bindObservable);
        }
    }

    @Override
    public void unsubscribeOnBind(BindObservable bindObservable) {
        bindObservables.remove(bindObservable);
    }

    @Override
    public boolean isBinded() {
        return view != null;
    }

    private void notifyOnBinded() {
        for (BindObservable bindObservable : bindObservables) {
            if (bindObservable != null)
                bindObservable.onBinded(bindObservable);
        }
        bindObservables.clear();
    }

    protected void addSubject(Disposable disposable) {
        subjectDisposables.add(disposable);
    }

    protected void disposeSubjects() {
        for (Disposable disposable : subjectDisposables) {
            disposable.dispose();
        }
        subjectDisposables.clear();
    }

    protected void dispose() {
        for (Disposable disposable : disposables) {
            disposable.dispose();
        }
        disposables.clear();
    }
}
