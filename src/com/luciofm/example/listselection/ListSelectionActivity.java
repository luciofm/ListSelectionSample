package com.luciofm.example.listselection;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListSelectionActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, android.R.id.text1, Cheeses.sCheeseStrings));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		getListView().setItemChecked(position, true);
	}
}