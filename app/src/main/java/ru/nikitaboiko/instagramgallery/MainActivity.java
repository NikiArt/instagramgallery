package ru.nikitaboiko.instagramgallery;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.nikitaboiko.instagramgallery.adapters.GiphyAdapter;
import ru.nikitaboiko.instagramgallery.presenters.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.activity_giphy_list)
    RecyclerView imageList;
    @BindView(R.id.activity_giphy_search_view)
    SearchView searchView;

    @Inject
    GiphyAdapter giphyAdapter;

    @InjectPresenter
    MainPresenter mainPresenter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.menu_giphy:
                return true;
            case R.id.menu_favourites:
                return true;
        }
        return false;
    };

    @ProvidePresenter
    public MainPresenter providePresenter() {
        MainPresenter presenter = new MainPresenter();
        App.instance().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.instance().getAppComponent().inject(this);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        ButterKnife.bind(this);
        imageList.setLayoutManager(new LinearLayoutManager(this));
        imageList.setAdapter(giphyAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(final String query) {
                setListCurrentSearchValue(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {
                return true;
            }
        });

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void setListCurrentSearchValue(String val) {
        mainPresenter.getGiphiesFromApi(val, giphyAdapter);
    }
}
