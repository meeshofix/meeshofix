import com.narvar.commons.utils.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class UtilsforcarrierPush {


    StringEntity payload;

public void runningTestcaseForMultipleTrackingnumber(){



        String current = System.getProperty("user.dir");
        File file = new File("/Users/akash/Desktop/trackingautomation/src/resources/Trackingnumber.csv");
        System.out.println("File for transaction number found");
        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<List<String>>();
        Scanner inputStream;

        try {
            inputStream = new Scanner(file);

            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] values = line.split(",");

                System.out.println("**");

                modifyTrackpayload("https://bac-p-gateway-indo.meesho.co.id/api/v1/narvar/shipment/update",
                      "/Users/akash/Desktop/trackingautomation/src/resources/CarrierPush.json", values[0],values[1]);

            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

      public void modifyTrackpayload(String url,String pathforpayload,String trackingNumbertobePassed,String scanCode){

          String url_for_push = url;
          String Pushpayloadpath = pathforpayload;
          String scancode=scanCode;



          StringEntity finalpayloadforpush = modifymyjsonforpushapi(Pushpayloadpath,trackingNumbertobePassed,scanCode);
          System.out.println("Final payload" + finalpayloadforpush.toString());
          HttpResponse rp;

          try {
              rp = post_request_without_basic_auth(url_for_push, finalpayloadforpush);
              /** this piece of code is to print the response and assertion */
              String responseBody = EntityUtils.toString(rp.getEntity());
              System.out.println("Response for meesho is"+responseBody);



          } catch (ClientProtocolException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }

      }






    public StringEntity modifymyjsonforpushapi(String filepath, String transaction, String scancode) {

        try {
            JSONParser parser=new JSONParser();
            Object object = parser.parse(new FileReader(filepath));
            String JSON = object.toString();

            Instant instant = Instant.now();
            String TimeInUtcFormat=instant.toString();

            Meesho meesho = JsonUtils.toObject(JSON, Meesho.class);

            meesho.getTracking().get(0).setTrackingNumber(transaction);
            meesho.getTracking().get(0).getEvents().get(0).setDate(TimeInUtcFormat);
            meesho.getTracking().get(0).getEvents().get(0).getStatusCodeMapping().setCode(scancode);
            meesho.getTracking().get(0).getEvents().get(0).setDate(Instant.now().toString());
            String jsonaspayload = JsonUtils.toJson(meesho);
            System.out.println("Modified payload is"+jsonaspayload);
            payload = new StringEntity(jsonaspayload);
        } catch (Exception e) {
            System.out.println("file not found");
        }
        return payload;
    }


    public HttpResponse post_request_without_basic_auth(String url,StringEntity payload) throws IOException {




        HttpPost post = new HttpPost(url);

        post.setHeader("apiKey", "03b3a053-33c5-46db-9a14-908f3c12177a");
        post.setHeader("Content-Type", "application/json");
        post.setHeader("account", "narvar");
        // post.setHeader("Authorization",authtoken);
        String str = EntityUtils.toString(payload);
        System.out.println("The payload passed is>>>>>>>>>>" + str);
        post.setEntity(payload);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(post);
        System.out.println(response);

        return response;

    }

    }







