package com.dft.onyx50demo.response

import com.google.gson.annotations.SerializedName

data class CastVoteResponse(
        @SerializedName("text") val message: String,
        @SerializedName("transactionId") val transacId: String,
        @SerializedName("votedTo") val partyName: String,
)