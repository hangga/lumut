package com.lumut.hangga.view;

import android.content.Context;
import android.view.View;

import com.lumut.hangga.repo.remote.GetDataService;
import com.lumut.hangga.repo.remote.RetrofitClientInstance;
import com.lumut.hangga.repo.remote.response.ItemResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {
    private Context context;
    private View view;
    private GetDataService getDataService;

    MainPresenter(View view, Context context) {
        this.view = view;
        this.context = context;
        getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    }

    void getData(){
        view.showProgress(true);
        getDataService.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ItemResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ItemResponse> itemResponse) {
                        view.showProgress(false);
                        if (itemResponse != null && itemResponse.size() > 0){
                            view.showResult(itemResponse);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showProgress(false);
                        view.showMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        view.showProgress(false);
                    }
                });
    }

    public interface View {
        void showResult(List<ItemResponse> items);

        void onEmpty();

        void showMessage(String message);

        void showProgress(boolean isShow);
    }
}
