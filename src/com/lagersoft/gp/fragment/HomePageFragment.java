package com.lagersoft.gp.fragment;


import com.lagersoft.gp.base.BaseFragment;
import com.lagersoft.grouppurchase.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * 首页
 * @author xiaoping
 *
 */
public class HomePageFragment extends BaseFragment {
	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_home_page, null);
		initTitleBar(inflater, view);
		return view;
	}
	
	private void initTitleBar(LayoutInflater inflater, View view2) {
		setTitleView(inflater, view);
		setTitleViewVisibility(View.GONE, R.id.back_btn, R.id.right_btn,
				R.id.right_progress).setTitleViewText(R.id.title,
				R.string.tab_home_page_text);
	}
}
