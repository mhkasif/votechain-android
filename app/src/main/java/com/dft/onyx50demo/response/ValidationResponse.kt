package com.dft.onyx50demo.response

import com.google.gson.annotations.SerializedName

data class ValidationResponse(
        @SerializedName("error") val error: String?,
        @SerializedName("data") val data: String?
)