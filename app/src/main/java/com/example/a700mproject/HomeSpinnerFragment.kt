package com.example.a700mproject

import android.view.View
import android.widget.AdapterView

interface HomeSpinnerFragment: AdapterView.OnItemSelectedListener {

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}