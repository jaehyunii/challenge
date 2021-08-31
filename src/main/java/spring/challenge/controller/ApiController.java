package spring.challenge.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.challenge.service.ApiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/api")
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();

        String urlStr = "http://api.data.go.kr/openapi/tn_pubr_public_fshlc_api?" +
                "serviceKey=32Mni6zfH9EMIW0pxIsdgNxktD%2F6gqHWYBknt5%2BBnNhg8y1sCT3aNJfZt6DBN99rTV0ZT1AOtQa8yekoIr4uPw%3D%3D" +
                "&pageNo=0" +
                "&numOfRows=5" +
                "&type=json";
        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        String returnLine;

        while((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n\r");
        }

        urlConnection.disconnect();

        apiService.init(result.toString());
        return result.toString();
    }

}
