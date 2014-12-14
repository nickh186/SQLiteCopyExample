package com.nhanna.example.sqlite.frag;

import com.nhanna.example.sqlite.R;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

public class AboutFragment extends DialogFragment {

	public static final String TAG = AboutFragment.class.getName();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Builder builder = new Builder(getActivity())
		.setTitle(R.string.action_about)
		.setPositiveButton("OK", null)
		.setMessage(R.string.about_text);
		return builder.create();
	}
}
