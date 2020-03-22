package web.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by AKARTAL on 27.12.2019.
 */
public class ArizaRestClient {

    public ClientArizaDto saveClientArizaDto(ClientArizaDto clientArizaDto) {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        String arizaDtoJson = gson.toJson(clientArizaDto);

        HttpPost post = new HttpPost("http://localhost:8080/rest/ariza/saveAriza");
        HttpEntity httpEntity = new StringEntity(arizaDtoJson, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            ClientArizaDto savedAriza = gson.fromJson(dataAsJsonStr, ClientArizaDto.class);
            return savedAriza;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClientArizaDto[] findAllClientArizaDto() {

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

            HttpPost post = new HttpPost("http://localhost:8080/rest/ariza/findAll");
            post.addHeader("content-type", "application/json");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)) {
                HttpEntity entity = response.getEntity();
                String dataAsJsonStr = EntityUtils.toString(entity);

                ClientArizaDto[] clientArizaDtos = gson.fromJson(dataAsJsonStr, ClientArizaDto[].class);

                return clientArizaDtos;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
