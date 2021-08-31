package spring.challenge.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import spring.challenge.entity.Domain;
import spring.challenge.repository.ApiRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiService {

    private final ApiRepository apiRepository;

    public void init(String jsonData) {
        try {
            JSONObject jObj;
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);
            JSONObject parseResponse = (JSONObject) jsonObject.get("response");
            JSONObject parseBody = (JSONObject) parseResponse.get("body");
            JSONArray array = (JSONArray) parseBody.get("items");

            for(int i=0; i<array.size(); i++) {
                jObj = (JSONObject) array.get(i);

                apiRepository.save(Domain.builder()
                        .fshlcNm(jObj.get("fshlcNm").toString())
                        .fshlcType(jObj.get("fshlcType").toString())
                        .rdnmadr(jObj.get("rdnmadr").toString())
                        .lnmadr(jObj.get("lnmadr").toString())
                        .latitude(jObj.get("latitude").toString())
                        .longitude(jObj.get("longitude").toString())
                        .fshlcPhoneNumber(jObj.get("fshlcPhoneNumber").toString())
                        .waterAr(jObj.get("waterAr").toString())
                        .kdfsh(jObj.get("kdfsh").toString())
                        .aceptncCo(jObj.get("aceptncCo").toString())
                        .wtrcFcltyType(jObj.get("wtrcFcltyType").toString())
                        .useCharge(jObj.get("useCharge").toString())
                        .mainPoint(jObj.get("mainPoint").toString())
                        .safentl(jObj.get("safentl").toString())
                        .cvntl(jObj.get("cvntl").toString())
                        .cfrTrrsrt(jObj.get("cfrTrrsrt").toString())
                        .phoneNumber(jObj.get("phoneNumber").toString())
                        .institutionNm(jObj.get("institutionNm").toString())
                        .referenceDate(jObj.get("referenceDate").toString())
                        .build());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
