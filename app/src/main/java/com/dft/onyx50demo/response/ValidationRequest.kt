package com.dft.onyx50demo.response

import com.google.gson.annotations.SerializedName

data class ValidationRequest(
        @SerializedName("voter_id") val voterId: String,
        @SerializedName("expiry_date") val expiryDate: String,
)