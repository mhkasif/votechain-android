package com.dft.onyx50demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.dft.onyx.NfiqMetrics;
import com.dft.onyxcamera.config.OnyxResult;
import com.dft.onyxcamera.util.UploadMatchResult;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

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
                    Bitmap resized = Bitmap.createScaledBitmap(processedImages.get(finalIndex), 640, 960, true);
                    resized.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                    File destination = new File(Environment.getExternalStorageDirectory(), "temp.jpg");


                    new uploadFileToServerTask().execute(destination.getAbsolutePath());
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
    private class uploadFileToServerTask extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... args) {
            MultipartUtility multipart = null;
            try {
                multipart = new MultipartUtility("https://vote-chain95.herokuapp.com/fingerprint", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // }


//add your file here.
            /*This is to add file content*/
            // for (int i = 0; i < myFileArray.size(); i++) {
            try {
                multipart.addFilePart("data",
                        new File( args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //}
            multipart.addFormField("voter_id","54698");
            multipart.addFormField("index","l1");
            List<String> response = null;
            try {
                response = multipart.finish();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                for (String line : response) {
                    try {
                        return line;

                        //   Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ManualMeasurementFragment()).commit();


                    } catch (Throwable t) {
                        Log.e("My App", "Could not parse malformed JSON:\"");
                    }
                    System.out.println("Upload Files Response:::" + line);
// get your server response here.
                    String responseString = line;
                }
            }catch (Exception e){

                return null;
            }

            return "false";
        }

        @Override
        protected void onPostExecute(String line) {

            if (line != null) {
                try {

                    JSONObject obj = new JSONObject(line);
                    if(obj.getString("data").contains("matched")){

                        startActivity(new Intent(activity, CastVoteActivity.class));

                    }

                    else {


                        MainApplication.setOnyxResult(null);
                        startActivity(new Intent(activity, OnyxSetupActivity.class));
                    }


                } catch (Exception e) {

                }
            }
            else{

                Toast.makeText(getApplication(), "Take image again or allow permission of writing in sd card", Toast.LENGTH_SHORT).show();

            }
        }
    }
    public class MultipartUtility {
        private final String boundary;
        private static final String LINE_FEED = "\r\n";
        private HttpURLConnection httpConn;
        private String charset;
        private OutputStream outputStream;
        private PrintWriter writer;

        /**
         * This constructor initializes a new HTTP POST request with content type
         * is set to multipart/form-data
         *
         * @param requestURL
         * @param charset
         * @throws IOException
         */
        public MultipartUtility(String requestURL, String charset)
                throws IOException {
            this.charset = charset;

            // creates a unique boundary based on time stamp
            boundary = "===" + System.currentTimeMillis() + "===";
            URL url = new URL(requestURL);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setUseCaches(false);
            httpConn.setDoOutput(true);    // indicates POST method
            httpConn.setDoInput(true);
            httpConn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);
            outputStream = httpConn.getOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
                    true);
        }

        /**
         * Adds a form field to the request
         *
         * @param name  field name
         * @param value field value
         */
        public void addFormField(String name, String value) {
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
                    .append(LINE_FEED);
            writer.append("Content-Type: text/plain; charset=" + charset).append(
                    LINE_FEED);
            writer.append(LINE_FEED);
            writer.append(value).append(LINE_FEED);
            writer.flush();
        }

        /**
         * Adds a upload file section to the request
         *
         * @param fieldName  name attribute in <input type="file" name="..." />
         * @param uploadFile a File to be uploaded
         * @throws IOException
         */
        public void addFilePart(String fieldName, File uploadFile)
                throws IOException {
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append(
                    "Content-Disposition: form-data; name=\"" + fieldName
                            + "\"; filename=\"" + fileName + "\"")
                    .append(LINE_FEED);
            writer.append(
                    "Content-Type: "
                            + URLConnection.guessContentTypeFromName(fileName))
                    .append(LINE_FEED);
            writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();

            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED);
            writer.flush();
        }

        /**
         * Adds a header field to the request.
         *
         * @param name  - name of the header field
         * @param value - value of the header field
         */
        public void addHeaderField(String name, String value) {
            writer.append(name + ": " + value).append(LINE_FEED);
            writer.flush();
        }

        /**
         * Completes the request and receives response from the server.
         *
         * @return a list of Strings as response in case the server returned
         * status OK, otherwise an exception is thrown.
         * @throws IOException
         */
        public List<String> finish() throws IOException {
            List<String> response = new ArrayList<String>();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();

            // checks server's status code first
            int status = httpConn.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        httpConn.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    response.add(line);
                }
                reader.close();
                httpConn.disconnect();
            } else {
                throw new IOException("Server returned non-OK status: " + status);
            }
            return response;
        }
    }
}
