//package com.dft.onyx50demo;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.os.Environment;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.dft.onyx50demo.matching.SharedPreferencesAuthStore;
//import com.dft.onyx50demo.networkUtils.ApiClient;
//import com.dft.onyx50demo.networkUtils.OnyxApi;
//import com.dft.onyxcamera.config.OnyxResult;
//import com.dft.onyxcamera.util.UploadMatchResult;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class OnyxImageryActivity extends Activity {
//    private static final String TAG = OnyxImageryActivity.class.getName();
//
//    private Activity activity;
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        setContentView(R.layout.activity_imagery);
//        activity = this;
//        ImageView rawImage1 = findViewById(R.id.rawImage1);
//        ImageView processedImage1 = findViewById(R.id.processedImage1);
//
//        ImageView rawImage2 = findViewById(R.id.rawImage2);
//        rawImage2.setVisibility(View.INVISIBLE);
//
//        ImageView processedImage2 = findViewById(R.id.processedImage2);
//        processedImage2.setVisibility(View.INVISIBLE);
//
//        ImageView rawImage3 = findViewById(R.id.rawImage3);
//        rawImage3.setVisibility(View.INVISIBLE);
//
//        ImageView processedImage3 = findViewById(R.id.processedImage3);
//        processedImage3.setVisibility(View.INVISIBLE);
//
//        ImageView rawImage4 = findViewById(R.id.rawImage4);
//        rawImage4.setVisibility(View.INVISIBLE);
//
//        ImageView processedImage4 = findViewById(R.id.processedImage4);
//        processedImage4.setVisibility(View.INVISIBLE);
//
//
//        TextView nfiqTextView1 = findViewById(R.id.nfiqText1);
//        nfiqTextView1.setVisibility(View.INVISIBLE);
//        TextView nfiqTextView2 = findViewById(R.id.nfiqText2);
//        nfiqTextView2.setVisibility(View.INVISIBLE);
//        TextView nfiqTextView4 = findViewById(R.id.nfiqText4);
//        nfiqTextView4.setVisibility(View.INVISIBLE);
//        rawImage1.setImageDrawable(null);
//        processedImage1.setImageDrawable(null);
//        rawImage2.setImageDrawable(null);
//        processedImage2.setImageDrawable(null);
//        rawImage3.setImageDrawable(null);
//        processedImage3.setImageDrawable(null);
//        rawImage4.setImageDrawable(null);
//        processedImage4.setImageDrawable(null);
//
//        OnyxResult onyxResult = MainApplication.getOnyxResult();
//        if (onyxResult == null) {
//            return;
//        }
//
//        ArrayList<Bitmap> rawImages = onyxResult.getRawFingerprintImages();
//        ArrayList<Bitmap> processedImages = onyxResult.getProcessedFingerprintImages();
//        if (onyxResult.getMetrics() != null && onyxResult.getMetrics().getNfiqMetrics() != null) {
//            Log.d("checking this condition","true");
////            List<NfiqMetrics> nfiqMetricsList = onyxResult.getMetrics().getNfiqMetrics();
////            for (int i = 0; i < nfiqMetricsList.size(); i++) {
////                switch (i) {
////                    case 0:
////                        if (nfiqMetricsList.get(i) != null) {
////                            nfiqTextView1.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
////                        }
////                    case 1:
////                        if (nfiqMetricsList.get(i) != null) {
////                            nfiqTextView2.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
////                        }
////                    case 2:
////                        if (nfiqMetricsList.get(i) != null) {
////                            nfiqTextView3.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
////                        }
////                    case 3:
////                        if (nfiqMetricsList.get(i) != null) {
////                            nfiqTextView4.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
////                        }
////                }
////            }
//        }
//        Log.d("checking flow","true");
////        Log.d("size",rawImages.size()+"");
//     int index=0;
//        if (rawImages != null) {
//            Log.d("size",rawImages.size()+"");
//            for (int i = 0; i < rawImages.size(); i++) {
//                switch (i) {
//                    case 0:
//                        if (rawImages.get(i) != null) {
//                            rawImage1.setImageBitmap(rawImages.get(i));
//                        }
//                        if (processedImages.get(i) != null) {
//                            processedImage1.setImageBitmap(processedImages.get(i));
//              index=i;
//                        }
//                        break;
////                    case 1:
////                        if (rawImages.get(i) != null) {
////                            rawImage2.setImageBitmap(rawImages.get(i));
////                        }
////                        if (processedImages.get(i) != null) {
////                            processedImage2.setImageBitmap(processedImages.get(i));
////                        }
////                        break;
////                    case 2:
////                        if (rawImages.get(i) != null) {
////                            rawImage3.setImageBitmap(rawImages.get(i));
////                        }
////                        if (processedImages.get(i) != null) {
////                            processedImage3.setImageBitmap(processedImages.get(i));
////                        }
////                        break;
////                    case 3:
////                        if (rawImages.get(i) != null) {
////                            rawImage4.setImageBitmap(rawImages.get(i));
////                        }
////                        if (processedImages.get(i) != null) {
////                            processedImage4.setImageBitmap(processedImages.get(i));
////                        }
////                        break;
//                }
//            }
//        }
//
//        if (onyxResult.getMetrics() != null && onyxResult.getMetrics().getTransactionId() != null) {
//            String transactionId = onyxResult.getMetrics().getTransactionId();
//            UploadMatchResult uploadMatchResult = new UploadMatchResult(this,
//                    transactionId,
//                    false,
//                    "INES");
//            uploadMatchResult.uploadMatchResult();
//        }
//
//        FileUtil fileUtil = new FileUtil();
//        fileUtil.checkExternalMedia(this);
//        if (onyxResult.getWsqData() != null && !onyxResult.getWsqData().isEmpty() && fileUtil.getWriteExternalStoragePermission(this)) {
//            for (int i = 0; i < onyxResult.getWsqData().size(); i++) {
//                fileUtil.writePNGImage(this, onyxResult.getProcessedFingerprintImages().get(i), "wsq" + i);
//                break;
//            }
//        }
//
//        fileUtil.checkExternalMedia(this);
//        if (onyxResult.getProcessedFingerprintImages() != null && !onyxResult.getProcessedFingerprintImages().isEmpty() && fileUtil.getWriteExternalStoragePermission(this)) {
//            for (int i = 0; i < onyxResult.getProcessedFingerprintImages().size(); i++) {
//                fileUtil.writePNGImage(this, onyxResult.getProcessedFingerprintImages().get(i), "png" + i);
//                break;
//            }
//        }
//
////        Button finishButton = findViewById(R.id.v);
//
//        Button verify = findViewById(R.id.finishButton);
//        int finalIndex = index;
//        verify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Log.d("verifying",finalIndex+" ");
//                try {
//                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//                    // 640x960
//                        Log.d("processed image",processedImages.get(finalIndex).toString());
//                    Bitmap resized = Bitmap.createScaledBitmap(processedImages.get(finalIndex), 640, 960, true);
//                    resized.compress(Bitmap.CompressFormat.PNG, 90, bytes);
//                    File destination = new File(Environment.getExternalStorageDirectory(), "temp.png");
//                    Log.d("destination",destination.getAbsolutePath());
//                    FileOutputStream fo;
//                    try {
//                        fo = new FileOutputStream(destination);
//                        fo.write(bytes.toByteArray());
//                        fo.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    OnyxApi onyxApi;
//
//                    SharedPreferencesAuthStore authstore;
//
//                    authstore = new SharedPreferencesAuthStore(getApplicationContext());
//
//                    onyxApi = ApiClient.INSTANCE.getOnyxApi();
//                    String voter_id=authstore.getVoterId();
//
//                    String index=authstore.getHandFingerString();
//                    File file = new File(destination.getAbsolutePath());
//
//                    RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
//
//// MultipartBody.Part is used to send also the actual file name
//                    MultipartBody.Part body =
//                            MultipartBody.Part.createFormData("data", file.getName(), reqFile);
//                    RequestBody description =
//                            RequestBody.create(
//                                    MultipartBody.FORM, voter_id);
//                    RequestBody description1 =
//                            RequestBody.create(
//                                    MultipartBody.FORM, index);
//                    // Parsing any Media type file;
//// onyxApi.fingerprint(description,description1,fileToUpload);
////                    call.enqueue(new Callback<ResponseBody>() {
////                        @Override
////                        public void onResponse(Call<ResponseBody> call,
////                                               Response<ResponseBody> response) {
////                            Log.v("Upload", "success");
////                        }
////
////                        @Override
////                        public void onFailure(Call<ResponseBody> call, Throwable t) {
////                            Log.e("Upload error:", t.getMessage());
////                        }
////                    });
//                    onyxApi.fingerprint(description,description1,body).enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                            JSONObject obj = null;
//                            try {
//                                obj = new JSONObject(response.body().string());
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            try {
//
//                                Log.v("response",response.body().string());
//                                Log.v("object",obj.toString());
//                                if(obj.getString("data").equals("matched")){
//
//                                    Toast.makeText(getApplication(),obj.getString("data") , Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(activity, CastVoteActivity.class));
//
//                        }
//
//                        else {
//
//                                    Toast.makeText(getApplication(),obj.getString("data") , Toast.LENGTH_SHORT).show();
//
//                            MainApplication.setOnyxResult(null);
//
//                            startActivity(new Intent(activity, OnyxSetupActivity.class));
//                        }
//                            } catch (JSONException | IOException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.e("Upload error:", t.getMessage());
//
//                            MainApplication.setOnyxResult(null);
//                            startActivity(new Intent(activity, OnyxSetupActivity.class));
//                        }
//                    });
//                 //   whenSendMultipartRequestUsingHttpClient_thenCorrect(destination.getPath(),"https://vote-chain95.herokuapp.com/fingerprint");
//                    //new uploadFileToServerTask().execute(destination.getAbsolutePath());
//                }catch (Exception e){}
//            }
//        });
//     //   finishButton.setText("Verify");
//
////        finishButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                MainApplication.setOnyxResult(null);
////                startActivity(new Intent(activity, OnyxSetupActivity.class));
////            }
////        });
//    }
////    private class uploadFileToServerTask extends AsyncTask<String, String, String> {
////
////
////        @Override
////        protected String doInBackground(String... args) {
////            MultipartUtility multipart = null;
////            try {
////                multipart = new MultipartUtility("https://vote-chain95.herokuapp.com/fingerprint", "UTF-8");
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////
////
////            try {
////                multipart.addFilePart("data",
////                        new File( args[0]));
////            } catch (IOException e) {
////                Log.d("fileerror",e.getMessage());
////                e.printStackTrace();
////            }
////
////            //}
////            multipart.addFormField("voter_id","8881212");
//////            multipart.addFormField("index","l1");
////            List<String> response = null;
////            try {
////                response = multipart.finish();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////            try {
////                for (String line : response) {
////                    try {
////                        return line;
////
////                        //   Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ManualMeasurementFragment()).commit();
////
////
////                    } catch (Throwable t) {
////                        Log.e("My App", "Could not parse malformed JSON:\"");
////                    }
////                    System.out.println("Upload Files Response:::" + line);
////// get your server response here.
////                    String responseString = line;
////                }
////            }catch (Exception e){
////
////                return null;
////            }
////
////            return "false";
////        }
////
////        @Override
////        protected void onPostExecute(String line) {
////
////            if (line != null) {
////                Log.d("hassan checking",line);
////
////                try {
////
////                    JSONObject obj = new JSONObject(line);
////                    if(obj.getString("data").contains("matched")){
////
////                        startActivity(new Intent(activity, CastVoteActivity.class));
////
////                    }
////
////                    else {
////
////
////                        MainApplication.setOnyxResult(null);
////                        startActivity(new Intent(activity, OnyxSetupActivity.class));
////                    }
////
////
////                } catch (Exception e) {
////
////                }
////            }
////            else{
////
////                Toast.makeText(getApplication(), "Error server", Toast.LENGTH_SHORT).show();
////
////            }
////        }
////    }
////    public class MultipartUtility {
////        private final String boundary;
////        private static final String LINE_FEED = "\r\n";
////        private HttpURLConnection httpConn;
////        private String charset;
////        private OutputStream outputStream;
////        private PrintWriter writer;
////
////        /**
////         * This constructor initializes a new HTTP POST request with content type
////         * is set to multipart/form-data
////         *
////         * @param requestURL
////         * @param charset
////         * @throws IOException
////         */
////        public MultipartUtility(String requestURL, String charset)
////                throws IOException {
////            this.charset = charset;
////
////            // creates a unique boundary based on time stamp
////            boundary = "===" + System.currentTimeMillis() + "===";
////            URL url = new URL(requestURL);
////            httpConn = (HttpURLConnection) url.openConnection();
////            httpConn.setUseCaches(false);
////            httpConn.setDoOutput(true);    // indicates POST method
////            httpConn.setDoInput(true);
////            httpConn.setRequestProperty("Content-Type",
////                    "multipart/form-data; boundary=" + boundary);
////            outputStream = httpConn.getOutputStream();
////            writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
////                    true);
////        }
////
////        /**
////         * Adds a form field to the request
////         *
////         * @param name  field name
////         * @param value field value
////         */
////        public void addFormField(String name, String value) {
////            writer.append("--" + boundary).append(LINE_FEED);
////            writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
////                    .append(LINE_FEED);
////            writer.append("Content-Type: text/plain; charset=" + charset).append(
////                    LINE_FEED);
////            writer.append(LINE_FEED);
////            writer.append(value).append(LINE_FEED);
////            writer.flush();
////        }
////
////        /**
////         * Adds a upload file section to the request
////         *
////         * @param fieldName  name attribute in <input type="file" name="..." />
////         * @param uploadFile a File to be uploaded
////         * @throws IOException
////         */
////        public void addFilePart(String fieldName, File uploadFile)
////                throws IOException {
////            String fileName = uploadFile.getName();
////            writer.append("--" + boundary).append(LINE_FEED);
////            writer.append(
////                    "Content-Disposition: form-data; name=\"" + fieldName
////                            + "\"; filename=\"" + fileName + "\"")
////                    .append(LINE_FEED);
////            writer.append(
////                    "Content-Type: "
////                            + URLConnection.guessContentTypeFromName(fileName))
////                    .append(LINE_FEED);
////            writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
////            writer.append(LINE_FEED);
////            writer.flush();
////
////            FileInputStream inputStream = new FileInputStream(uploadFile);
////            byte[] buffer = new byte[4096];
////            int bytesRead = -1;
////            while ((bytesRead = inputStream.read(buffer)) != -1) {
////                outputStream.write(buffer, 0, bytesRead);
////            }
////            outputStream.flush();
////            inputStream.close();
////            writer.append(LINE_FEED);
////            writer.flush();
////        }
////
////        /**
////         * Adds a header field to the request.
////         *
////         * @param name  - name of the header field
////         * @param value - value of the header field
////         */
////        public void addHeaderField(String name, String value) {
////            writer.append(name + ": " + value).append(LINE_FEED);
////            writer.flush();
////        }
////
////        /**
////         * Completes the request and receives response from the server.
////         *
////         * @return a list of Strings as response in case the server returned
////         * status OK, otherwise an exception is thrown.
////         * @throws IOException
////         */
////        public List<String> finish() throws IOException {
////            List<String> response = new ArrayList<String>();
////            writer.append(LINE_FEED).flush();
////            writer.append("--" + boundary + "--").append(LINE_FEED);
////            writer.close();
////Log.d("data CHECKING",LINE_FEED);
////            // checks server's status code first
////            int status = httpConn.getResponseCode();
////            if (status == HttpURLConnection.HTTP_OK) {
////                BufferedReader reader = new BufferedReader(new InputStreamReader(
////                        httpConn.getInputStream()));
////                String line = null;
////                while ((line = reader.readLine()) != null) {
////                    response.add(line);
////                }
////                reader.close();
////                httpConn.disconnect();
////            } else {
//////                Random r=new Random(2);
//////                int i=r.nextInt();
////////
////////                startActivity(new Intent(activity, CastVoteActivity.class));
//////                if(i==1) {
//////                    startActivity(new Intent(activity, CastVoteActivity.class));
//////                }
//////                else{
//////                   // startActivity(new Intent(activity, CastVoteActivity.class));
//////
//////                }
////                Log.d("response messsage",httpConn.getResponseMessage());
////                throw new IOException("Server returned non-OK status: " + status);
////            }
////            return response;
////        }
////    }
////public static String executeMultipartPost(String url, String imgPath, String field1, String field2){
////    try
////    {
////        File file1 = new File(imgPath);
////
////                MultipartEntityBuilder entBuilder = MultipartEntityBuilder.create();
////        entBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
////        entBuilder.addBinaryBody(file1.getName(), file1);
////
////        //Extras
////        entBuilder.addPart("command", new StringBody("uploadImages"));
////
////    /*
////        If you need to send more files...
////
////        entBuilder.addBinaryBody(file2.getName(), file2);
////        entBuilder.addBinaryBody(file3.getName(), file3);
////        ...
////    */
////
////        HttpPost post = new HttpPost("http://jakarata.apache.org/");
////        HttpEntity entity = entBuilder.build();
////        post.setEntity(entity);
////        RequestLine in = post.getRequestLine();
////
////// hand
//////        HttpResponse response = (HttpResponse) client.execute(post);
//////        HttpEntity httpEntity = response.getEntity();
////
////        return EntityUtils.toString(httpEntity);
////    } catch (UnsupportedEncodingException e) {
////        e.printStackTrace();
////    } catch (IOException e) {
////        e.printStackTrace();
////    }
////}
////public void whenSendMultipartRequestUsingHttpClient_thenCorrect(String filepath,String url)
////        throws ClientProtocolException, IOException {
////                Log.d("request checking",filepath);
////    CloseableHttpClient client = HttpClients.createDefault();
////    HttpPost httpPost = new HttpPost("https://vote-chain95.herokuapp.com/fingerprint");
////
////    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
////
//////            multipart.addFormField("voter_id","8881212");
////////            multipart.addFormField("index","l1");
////    builder.addTextBody("voter_id","8881212");
////    builder.addTextBody("index","l1");
////    builder.addBinaryBody(
////            "data", new File(filepath), ContentType.MULTIPART_FORM_DATA, "temp.png");
////
////    HttpEntity multipart = builder.build();
////    httpPost.setEntity(multipart);
////
////    Log.d("response","hassan response");
////    CloseableHttpResponse response = client.execute(httpPost);
////    Log.d("response",response.getStatusLine().getStatusCode()+"");
////    client.close();
////}
//
///*
//*
//* */
//}


package com.dft.onyx50demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dft.onyx50demo.matching.SharedPreferencesAuthStore;
import com.dft.onyx50demo.networkUtils.ApiClient;
import com.dft.onyx50demo.networkUtils.OnyxApi;
import com.dft.onyxcamera.config.OnyxResult;
import com.dft.onyxcamera.util.UploadMatchResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnyxImageryActivity extends Activity {
    private static final String TAG = OnyxImageryActivity.class.getName();

    private Activity activity;

    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.activity_imagery);
        activity = this;
        ImageView rawImage1 = findViewById(R.id.rawImage1);
        ImageView processedImage1 = findViewById(R.id.processedImage1);

        ImageView rawImage2 = findViewById(R.id.rawImage2);
        rawImage2.setVisibility(View.INVISIBLE);

        ImageView processedImage2 = findViewById(R.id.processedImage2);
        processedImage2.setVisibility(View.INVISIBLE);

        ImageView rawImage3 = findViewById(R.id.rawImage3);
        rawImage3.setVisibility(View.INVISIBLE);

        ImageView processedImage3 = findViewById(R.id.processedImage3);
        processedImage3.setVisibility(View.INVISIBLE);

        ImageView rawImage4 = findViewById(R.id.rawImage4);
        rawImage4.setVisibility(View.INVISIBLE);

        ImageView processedImage4 = findViewById(R.id.processedImage4);
        processedImage4.setVisibility(View.INVISIBLE);


        TextView nfiqTextView1 = findViewById(R.id.nfiqText1);
        nfiqTextView1.setVisibility(View.INVISIBLE);
        TextView nfiqTextView2 = findViewById(R.id.nfiqText2);
        nfiqTextView2.setVisibility(View.INVISIBLE);
        TextView nfiqTextView4 = findViewById(R.id.nfiqText4);
        nfiqTextView4.setVisibility(View.INVISIBLE);
        rawImage1.setImageDrawable(null);
        processedImage1.setImageDrawable(null);
        rawImage2.setImageDrawable(null);
        processedImage2.setImageDrawable(null);
        rawImage3.setImageDrawable(null);
        processedImage3.setImageDrawable(null);
        rawImage4.setImageDrawable(null);
        processedImage4.setImageDrawable(null);

        OnyxResult onyxResult = MainApplication.getOnyxResult();
        if (onyxResult == null) {
            return;
        }

        ArrayList<Bitmap> rawImages = onyxResult.getRawFingerprintImages();
        ArrayList<Bitmap> processedImages = onyxResult.getProcessedFingerprintImages();
        if (onyxResult.getMetrics() != null && onyxResult.getMetrics().getNfiqMetrics() != null) {
            Log.d("checking this condition","true");
//            List<NfiqMetrics> nfiqMetricsList = onyxResult.getMetrics().getNfiqMetrics();
//            for (int i = 0; i < nfiqMetricsList.size(); i++) {
//                switch (i) {
//                    case 0:
//                        if (nfiqMetricsList.get(i) != null) {
//                            nfiqTextView1.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
//                        }
//                    case 1:
//                        if (nfiqMetricsList.get(i) != null) {
//                            nfiqTextView2.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
//                        }
//                    case 2:
//                        if (nfiqMetricsList.get(i) != null) {
//                            nfiqTextView3.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
//                        }
//                    case 3:
//                        if (nfiqMetricsList.get(i) != null) {
//                            nfiqTextView4.setText("NFIQ: " + String.valueOf(nfiqMetricsList.get(i).getNfiqScore()));
//                        }
//                }
//            }
        }
        Log.d("checking flow","true");
//        Log.d("size",rawImages.size()+"");
        int index=0;
        if (rawImages != null) {
            Log.d("size",rawImages.size()+"");
            for (int i = 0; i < rawImages.size(); i++) {
                switch (i) {
                    case 0:
                        if (rawImages.get(i) != null) {
                            rawImage1.setImageBitmap(rawImages.get(i));
                        }
                        if (processedImages.get(i) != null) {
                            processedImage1.setImageBitmap(processedImages.get(i));
                            index=i;
                        }
                        break;
//                    case 1:
//                        if (rawImages.get(i) != null) {
//                            rawImage2.setImageBitmap(rawImages.get(i));
//                        }
//                        if (processedImages.get(i) != null) {
//                            processedImage2.setImageBitmap(processedImages.get(i));
//                        }
//                        break;
//                    case 2:
//                        if (rawImages.get(i) != null) {
//                            rawImage3.setImageBitmap(rawImages.get(i));
//                        }
//                        if (processedImages.get(i) != null) {
//                            processedImage3.setImageBitmap(processedImages.get(i));
//                        }
//                        break;
//                    case 3:
//                        if (rawImages.get(i) != null) {
//                            rawImage4.setImageBitmap(rawImages.get(i));
//                        }
//                        if (processedImages.get(i) != null) {
//                            processedImage4.setImageBitmap(processedImages.get(i));
//                        }
//                        break;
                }
            }
        }

        if (onyxResult.getMetrics() != null && onyxResult.getMetrics().getTransactionId() != null) {
            String transactionId = onyxResult.getMetrics().getTransactionId();
            UploadMatchResult uploadMatchResult = new UploadMatchResult(this,
                    transactionId,
                    false,
                    "INES");
            uploadMatchResult.uploadMatchResult();
        }

        FileUtil fileUtil = new FileUtil();
        fileUtil.checkExternalMedia(this);
        if (onyxResult.getWsqData() != null && !onyxResult.getWsqData().isEmpty() && fileUtil.getWriteExternalStoragePermission(this)) {
            for (int i = 0; i < onyxResult.getWsqData().size(); i++) {
                fileUtil.writeToSDFile(this, onyxResult.getWsqData().get(i), "wsq" + i);
                break;
            }
        }

        fileUtil.checkExternalMedia(this);
        if (onyxResult.getProcessedFingerprintImages() != null && !onyxResult.getProcessedFingerprintImages().isEmpty() && fileUtil.getWriteExternalStoragePermission(this)) {
            for (int i = 0; i < onyxResult.getProcessedFingerprintImages().size(); i++) {
                fileUtil.writePNGToSDFile(this, onyxResult.getProcessedFingerprintImages().get(i), "png" + i);
                break;
            }
        }

        Button finishButton = findViewById(R.id.finishButton1);

        Button verify = findViewById(R.id.finishButton);
        int finalIndex = index;
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("verifying",finalIndex+" ");
                try {
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    // 640x960
                    Log.d("processed image",processedImages.get(finalIndex).toString());
                    Bitmap resized = Bitmap.createScaledBitmap(processedImages.get(finalIndex), 640, 960, true);
                    resized.compress(Bitmap.CompressFormat.PNG, 90, bytes);
                    File destination = new File(Environment.getExternalStorageDirectory(), "temp.png");
                    Log.d("destination",destination.getAbsolutePath());
                    FileOutputStream fo;
                    try {
                        fo = new FileOutputStream(destination);
                        fo.write(bytes.toByteArray());
                        fo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    OnyxApi onyxApi;

                    SharedPreferencesAuthStore authstore;

                    authstore = new SharedPreferencesAuthStore(getApplicationContext());

                    onyxApi = ApiClient.INSTANCE.getOnyxApi();
                    String voter_id=authstore.getVoterId();

                    String index=authstore.getHandFingerString();
                    File file = new File(destination.getAbsolutePath());

                    RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);

// MultipartBody.Part is used to send also the actual file name
                    MultipartBody.Part body =
                            MultipartBody.Part.createFormData("data", file.getName(), reqFile);
                    RequestBody description =
                            RequestBody.create(
                                    MultipartBody.FORM, voter_id);
                    RequestBody description1 =
                            RequestBody.create(
                                    MultipartBody.FORM, index);
                    // Parsing any Media type file;
// onyxApi.fingerprint(description,description1,fileToUpload);
//                    call.enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call,
//                                               Response<ResponseBody> response) {
//                            Log.v("Upload", "success");
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.e("Upload error:", t.getMessage());
//                        }
//                    });
                    onyxApi.fingerprint(description,description1,body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                            JSONObject obj = null;
                            try {
                                obj = new JSONObject(response.body().string());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {

                                Log.v("response",response.body().string());
                                Log.v("object",obj.toString());
                                if(obj.getString("data").equals("matched")){

                                    Toast.makeText(getApplication(),obj.getString("data") , Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(activity, CastVoteActivity.class));

                                }

                                else {

                                    Toast.makeText(getApplication(),obj.getString("data") , Toast.LENGTH_SHORT).show();

                                    MainApplication.setOnyxResult(null);

                                    startActivity(new Intent(activity, OnyxSetupActivity.class));
                                }
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.e("Upload error:", t.getMessage());

                            MainApplication.setOnyxResult(null);
                            startActivity(new Intent(activity, OnyxSetupActivity.class));
                        }
                    });
                    //   whenSendMultipartRequestUsingHttpClient_thenCorrect(destination.getPath(),"https://vote-chain95.herokuapp.com/fingerprint");
                    //new uploadFileToServerTask().execute(destination.getAbsolutePath());
                }catch (Exception e){}
            }
        });
        //   finishButton.setText("Verify");

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainApplication.setOnyxResult(null);
                startActivity(new Intent(activity, OnyxSetupActivity.class));
            }
        });
    }
//    private class uploadFileToServerTask extends AsyncTask<String, String, String> {
//
//
//        @Override
//        protected String doInBackground(String... args) {
//            MultipartUtility multipart = null;
//            try {
//                multipart = new MultipartUtility("https://vote-chain95.herokuapp.com/fingerprint", "UTF-8");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//            try {
//                multipart.addFilePart("data",
//                        new File( args[0]));
//            } catch (IOException e) {
//                Log.d("fileerror",e.getMessage());
//                e.printStackTrace();
//            }
//
//            //}
//            multipart.addFormField("voter_id","8881212");
////            multipart.addFormField("index","l1");
//            List<String> response = null;
//            try {
//                response = multipart.finish();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                for (String line : response) {
//                    try {
//                        return line;
//
//                        //   Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ManualMeasurementFragment()).commit();
//
//
//                    } catch (Throwable t) {
//                        Log.e("My App", "Could not parse malformed JSON:\"");
//                    }
//                    System.out.println("Upload Files Response:::" + line);
//// get your server response here.
//                    String responseString = line;
//                }
//            }catch (Exception e){
//
//                return null;
//            }
//
//            return "false";
//        }
//
//        @Override
//        protected void onPostExecute(String line) {
//
//            if (line != null) {
//                Log.d("hassan checking",line);
//
//                try {
//
//                    JSONObject obj = new JSONObject(line);
//                    if(obj.getString("data").contains("matched")){
//
//                        startActivity(new Intent(activity, CastVoteActivity.class));
//
//                    }
//
//                    else {
//
//
//                        MainApplication.setOnyxResult(null);
//                        startActivity(new Intent(activity, OnyxSetupActivity.class));
//                    }
//
//
//                } catch (Exception e) {
//
//                }
//            }
//            else{
//
//                Toast.makeText(getApplication(), "Error server", Toast.LENGTH_SHORT).show();
//
//            }
//        }
//    }
//    public class MultipartUtility {
//        private final String boundary;
//        private static final String LINE_FEED = "\r\n";
//        private HttpURLConnection httpConn;
//        private String charset;
//        private OutputStream outputStream;
//        private PrintWriter writer;
//
//        /**
//         * This constructor initializes a new HTTP POST request with content type
//         * is set to multipart/form-data
//         *
//         * @param requestURL
//         * @param charset
//         * @throws IOException
//         */
//        public MultipartUtility(String requestURL, String charset)
//                throws IOException {
//            this.charset = charset;
//
//            // creates a unique boundary based on time stamp
//            boundary = "===" + System.currentTimeMillis() + "===";
//            URL url = new URL(requestURL);
//            httpConn = (HttpURLConnection) url.openConnection();
//            httpConn.setUseCaches(false);
//            httpConn.setDoOutput(true);    // indicates POST method
//            httpConn.setDoInput(true);
//            httpConn.setRequestProperty("Content-Type",
//                    "multipart/form-data; boundary=" + boundary);
//            outputStream = httpConn.getOutputStream();
//            writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
//                    true);
//        }
//
//        /**
//         * Adds a form field to the request
//         *
//         * @param name  field name
//         * @param value field value
//         */
//        public void addFormField(String name, String value) {
//            writer.append("--" + boundary).append(LINE_FEED);
//            writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
//                    .append(LINE_FEED);
//            writer.append("Content-Type: text/plain; charset=" + charset).append(
//                    LINE_FEED);
//            writer.append(LINE_FEED);
//            writer.append(value).append(LINE_FEED);
//            writer.flush();
//        }
//
//        /**
//         * Adds a upload file section to the request
//         *
//         * @param fieldName  name attribute in <input type="file" name="..." />
//         * @param uploadFile a File to be uploaded
//         * @throws IOException
//         */
//        public void addFilePart(String fieldName, File uploadFile)
//                throws IOException {
//            String fileName = uploadFile.getName();
//            writer.append("--" + boundary).append(LINE_FEED);
//            writer.append(
//                    "Content-Disposition: form-data; name=\"" + fieldName
//                            + "\"; filename=\"" + fileName + "\"")
//                    .append(LINE_FEED);
//            writer.append(
//                    "Content-Type: "
//                            + URLConnection.guessContentTypeFromName(fileName))
//                    .append(LINE_FEED);
//            writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
//            writer.append(LINE_FEED);
//            writer.flush();
//
//            FileInputStream inputStream = new FileInputStream(uploadFile);
//            byte[] buffer = new byte[4096];
//            int bytesRead = -1;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//            outputStream.flush();
//            inputStream.close();
//            writer.append(LINE_FEED);
//            writer.flush();
//        }
//
//        /**
//         * Adds a header field to the request.
//         *
//         * @param name  - name of the header field
//         * @param value - value of the header field
//         */
//        public void addHeaderField(String name, String value) {
//            writer.append(name + ": " + value).append(LINE_FEED);
//            writer.flush();
//        }
//
//        /**
//         * Completes the request and receives response from the server.
//         *
//         * @return a list of Strings as response in case the server returned
//         * status OK, otherwise an exception is thrown.
//         * @throws IOException
//         */
//        public List<String> finish() throws IOException {
//            List<String> response = new ArrayList<String>();
//            writer.append(LINE_FEED).flush();
//            writer.append("--" + boundary + "--").append(LINE_FEED);
//            writer.close();
//Log.d("data CHECKING",LINE_FEED);
//            // checks server's status code first
//            int status = httpConn.getResponseCode();
//            if (status == HttpURLConnection.HTTP_OK) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(
//                        httpConn.getInputStream()));
//                String line = null;
//                while ((line = reader.readLine()) != null) {
//                    response.add(line);
//                }
//                reader.close();
//                httpConn.disconnect();
//            } else {
////                Random r=new Random(2);
////                int i=r.nextInt();
//////
//////                startActivity(new Intent(activity, CastVoteActivity.class));
////                if(i==1) {
////                    startActivity(new Intent(activity, CastVoteActivity.class));
////                }
////                else{
////                   // startActivity(new Intent(activity, CastVoteActivity.class));
////
////                }
//                Log.d("response messsage",httpConn.getResponseMessage());
//                throw new IOException("Server returned non-OK status: " + status);
//            }
//            return response;
//        }
//    }
//public static String executeMultipartPost(String url, String imgPath, String field1, String field2){
//    try
//    {
//        File file1 = new File(imgPath);
//
//                MultipartEntityBuilder entBuilder = MultipartEntityBuilder.create();
//        entBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//        entBuilder.addBinaryBody(file1.getName(), file1);
//
//        //Extras
//        entBuilder.addPart("command", new StringBody("uploadImages"));
//
//    /*
//        If you need to send more files...
//
//        entBuilder.addBinaryBody(file2.getName(), file2);
//        entBuilder.addBinaryBody(file3.getName(), file3);
//        ...
//    */
//
//        HttpPost post = new HttpPost("http://jakarata.apache.org/");
//        HttpEntity entity = entBuilder.build();
//        post.setEntity(entity);
//        RequestLine in = post.getRequestLine();
//
//// hand
////        HttpResponse response = (HttpResponse) client.execute(post);
////        HttpEntity httpEntity = response.getEntity();
//
//        return EntityUtils.toString(httpEntity);
//    } catch (UnsupportedEncodingException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//public void whenSendMultipartRequestUsingHttpClient_thenCorrect(String filepath,String url)
//        throws ClientProtocolException, IOException {
//                Log.d("request checking",filepath);
//    CloseableHttpClient client = HttpClients.createDefault();
//    HttpPost httpPost = new HttpPost("https://vote-chain95.herokuapp.com/fingerprint");
//
//    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//
////            multipart.addFormField("voter_id","8881212");
//////            multipart.addFormField("index","l1");
//    builder.addTextBody("voter_id","8881212");
//    builder.addTextBody("index","l1");
//    builder.addBinaryBody(
//            "data", new File(filepath), ContentType.MULTIPART_FORM_DATA, "temp.png");
//
//    HttpEntity multipart = builder.build();
//    httpPost.setEntity(multipart);
//
//    Log.d("response","hassan response");
//    CloseableHttpResponse response = client.execute(httpPost);
//    Log.d("response",response.getStatusLine().getStatusCode()+"");
//    client.close();
//}

    /*
     *
     * */
}