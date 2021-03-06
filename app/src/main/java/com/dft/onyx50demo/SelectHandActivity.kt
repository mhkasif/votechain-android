package com.dft.onyx50demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.dft.onyx50demo.databinding.ActivitySelectHandBinding
import com.dft.onyx50demo.matching.SharedPreferencesAuthStore

class SelectHandActivity : Activity() {

    var handString = "r"
    var fingerString = "1"

    lateinit var binding: ActivitySelectHandBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectHandBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()
    }

    private fun setUpViews() {
        val handArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)

        handArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        handArrayAdapter.addAll(listOf("r", "l"))

        binding.handSelectionSpinner.adapter = handArrayAdapter

        binding.handSelectionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                handString = handArrayAdapter.getItem(position) ?: "r"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }


        val fingerArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)

        fingerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fingerArrayAdapter.addAll(listOf("1", "2", "3", "4", "5"))

        binding.fingerSelectionSpinner.adapter = fingerArrayAdapter

        binding.fingerSelectionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                fingerString = fingerArrayAdapter.getItem(position) ?: "1"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.btnNext.setOnClickListener {
            SharedPreferencesAuthStore(this).handFingerString = "$handString$fingerString"
            val i = Intent(applicationContext, OnyxSetupActivity::class.java)
            i.putExtra("finger","$handString$fingerString")
            startActivity(i)
         //   startActivity(Intent(this, OnyxSetupActivity::class.java))

        }
    }
}