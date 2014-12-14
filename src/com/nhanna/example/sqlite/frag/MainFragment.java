package com.nhanna.example.sqlite.frag;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.nhanna.example.sqlite.R;
import com.nhanna.example.sqlite.data.SQLiteHelper;
import com.nhanna.example.sqlite.util.SQLiteUtils;

public class MainFragment extends Fragment implements OnClickListener {

	public static final String TAG = MainFragment.class.getName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		
		view.findViewById(R.id.sqlite_copy_button).setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* Add place holder data */
		SQLiteHelper helper = new SQLiteHelper(getActivity());
		helper.addPlaceholderData();
		
		setRetainInstance(true);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sqlite_copy_button:
			copy();
			break;

		default:
			break;
		}
	}
	
	private void copy() {
		try {
			
			SQLiteUtils.copyPackageDatabase(getActivity(), Environment.getExternalStorageDirectory()+"/sqlite_db_copy", SQLiteHelper.DB_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
