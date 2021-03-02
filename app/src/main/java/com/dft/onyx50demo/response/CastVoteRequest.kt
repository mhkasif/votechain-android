package com.dft.onyx50demo.response

import com.google.gson.annotations.SerializedName

data class CastVoteRequest(
        @SerializedName("voter_id") val voterId: String,
        @SerializedName("partyName") val partyName: String
)