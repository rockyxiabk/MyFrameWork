package com.rocky.myframework.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.rocky.myframework.DetailActivity;
import com.rocky.myframework.R;
import com.rocky.myframework.adapter.MyAdapter;
import com.rocky.myframework.bean.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    @Bind(R.id.pullToRefreshListView)
    PullToRefreshListView pullToRefreshListView;
    private List<Person> list;
    private MyAdapter adapter;

    public MainFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        initDate();
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startDetailActivity();
            }
        });
        return view;
    }

    private void startDetailActivity() {
        startActivity(new Intent(getActivity(), DetailActivity.class));
    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Person person = new Person();
            person.setName("asdf" + i);
            person.setNum(System.currentTimeMillis() + "");
            list.add(person);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new MyAdapter(getContext(), list);
        pullToRefreshListView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
