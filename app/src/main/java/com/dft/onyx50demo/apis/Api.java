package com.dft.onyx50demo.apis;

import retrofit2.Retrofit;

public class Api {

    public static ApiInterface getClient() {

        // change your base URL
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("https://vote-chain95.herokuapp.com/") //Set the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }
}