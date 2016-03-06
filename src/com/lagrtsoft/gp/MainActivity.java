package com.lagrtsoft.gp;

import com.lagersoft.gp.fragment.HomePageFragment;
import com.lagersoft.gp.fragment.MeFragment;
import com.lagersoft.gp.fragment.SellersFragment;
import com.lagersoft.gp.utils.CommonUtil;
import com.lagersoft.grouppurchase.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * FragmentTabHost 实现的Tab页卡界面
 * @author xiaoping
 *
 */
public class MainActivity extends FragmentActivity {


	private static final String TAB_ACTION_CENTER = "home_page"; // 入口 首页
	private static final String TAB_SELLERS = "sellers_page"; // 商家
	private static final String TAB_ME = "me_page"; //我

	private static final float TAB_TEXT_SIZE = 12;

	private FragmentTabHost mFragmentTabHost = null;
	
	//三个页面的图片资源Id
	private int[] iconResIDs = { 
			R.drawable.selector_tab_homepage,
			R.drawable.selector_tab_sellers,
			R.drawable.selector_tab_me };
	//三个页面的名称Id
	private int[] textResIDs = { R.string.tab_home_page_text,
			R.string.tab_sellers_text, R.string.tab_me_text };
	//三个页面代表字符串
	public String[] tabSpecs = { 
			TAB_ACTION_CENTER, 
			TAB_SELLERS,
			TAB_ME };
	//三个页面对应的Fragment对应的类类型(Class type)
	private Class<?>[] fragmentClasses = { HomePageFragment.class,
			SellersFragment.class, MeFragment.class };
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFragmentTabHost();
	}
	
	@Override
	protected void onResume() {
		System.out.println("mainactivity onresume");
		if(CommonUtil.MAIN_FRAGMENT_TAG_INDEX != 0){
			mFragmentTabHost.setCurrentTab(CommonUtil.MAIN_FRAGMENT_TAG_INDEX);
			CommonUtil.MAIN_FRAGMENT_TAG_INDEX = 0;
		}
		super.onResume();
	}
	
	@Override
	protected void onResumeFragments() {
		// TODO Auto-generated method stub
		System.out.println("mainactivity onresume fragments");
		super.onResumeFragments();
	}

	//加载FragmentTabHost
	private void initFragmentTabHost() {
		//获取到FragmentTabHost对象
		mFragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mFragmentTabHost.setup(this, getSupportFragmentManager(),
				android.R.id.tabcontent);
		for(int i=0; i<iconResIDs.length; i++){
			View view = LayoutInflater.from(this).inflate(R.layout.tab_indicator,
					null);
			ImageView iv = (ImageView) view.findViewById(R.id.tabIV);
			TextView tv = (TextView) view.findViewById(R.id.tabText);
			tv.setTextSize(TAB_TEXT_SIZE);
			iv.setImageResource(iconResIDs[i]);
			tv.setText(getResources().getString(textResIDs[i]));
			mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tabSpecs[i])
					.setIndicator(view), fragmentClasses[i], null);
		}
		
	}
}
