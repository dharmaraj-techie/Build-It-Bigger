package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.dharmaraj.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Dharmaraj on 29-09-2017.
 */
class EndpointsAsyncTask extends AsyncTask<SimpleIdlingResource, Void, String> {
    private static MyApi myApiService = null;

    private AsyncResponse asyncResponse = null ;
    private SimpleIdlingResource idlingResource = null;

    public interface AsyncResponse {
         void response(String output);
    }

    public EndpointsAsyncTask(AsyncResponse asyncResponse){
        this.asyncResponse = asyncResponse;
    }

    @Override
    protected String doInBackground(SimpleIdlingResource... params) {

        idlingResource = params[0];
        if (idlingResource != null) {
            idlingResource.setIdleState(false);
        }

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.42.111:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.sayJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        asyncResponse.response(result);
        if (idlingResource != null) {
            idlingResource.setIdleState(true);
        }
    }
}
