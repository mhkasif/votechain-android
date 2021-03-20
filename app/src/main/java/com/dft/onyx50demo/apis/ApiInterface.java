package com.dft.onyx50demo.apis;
import android.database.Observable;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @POST("/fingerprint")
    Observable<ResponseBody> sendFingerprint(@Part("index") RequestBody index,
                                           @Part("voter_id") RequestBody voter_id,
                                           @Part MultipartBody.Part image);

    //pass it like this
//    File file = new File("/storage/emulated/0/Download/Corrections 6.jpg");
//    RequestBody requestFile =
//            RequestBody.create(MediaType.parse("multipart/form-data"), file);
//
//    // MultipartBody.Part is used to send also the actual file name
//    MultipartBody.Part body =
//            MultipartBody.Part.createFormData("image", file.getName(), requestFile);
//
//    // add another part within the multipart request
//    RequestBody fullName =
//            RequestBody.create(MediaType.parse("multipart/form-data"), "Your Name");

}