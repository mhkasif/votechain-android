package com.dft.onyx50demo

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dft.onyx50demo.databinding.ActivityCastVoteBinding
import com.dft.onyx50demo.matching.SharedPreferencesAuthStore
import com.dft.onyx50demo.networkUtils.ApiClient
import com.dft.onyx50demo.networkUtils.OnyxApi
import com.dft.onyx50demo.response.CastVoteRequest
import com.dft.onyx50demo.response.CastVoteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CastVoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCastVoteBinding

    private var onyxApi: OnyxApi = ApiClient.onyxApi

    var authstore: SharedPreferencesAuthStore? = null

    private lateinit var dialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCastVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        authstore = SharedPreferencesAuthStore(this)

        binding.voterIdTxt.text = authstore!!.voterId
        binding.partySpinner.setAdapter(ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayListOf(
                "PTI",
                "PPP",
                "PMLN"
        )))

        binding.dropdownParty.setOnClickListener {
            binding.partySpinner.showDropDown()
        }

        binding.confirmVote.setOnClickListener {
            if (binding.partySpinner.text.isEmpty()) {
                Toast.makeText(this, "Please select a party", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dialog = ProgressDialog.show(this, "Please wait", "Loading")
            onyxApi.castVote(CastVoteRequest(binding.voterIdTxt.text.toString(), binding.partySpinner.text.toString()))
                    .enqueue(object : Callback<CastVoteResponse> {
                        override fun onResponse(call: Call<CastVoteResponse>, response: Response<CastVoteResponse>) {
                            dialog.hide()
                            if (response.body() != null) {
                                Toast.makeText(baseContext, response.body()!!.message, Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<CastVoteResponse>, t: Throwable) {
                            dialog.hide()
                            Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                        }

                    });

        }

    }

}