package com.clonelol.config;

import com.clonelol.config.dto.VersionDto;
import com.clonelol.config.dto.property.VersionInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class VersionCheck {
    public static String profileiconVersion = null;
    public static String summonerVersion = null;
    public static String championVersion = null;
    public static String mapVersion = null;
    public static String languageVersion = null;
    public static String stickerVersion = null;
    public static String itemVersion = null;

    public static void checkVersion() {
        BufferedReader br = null;
        try{
            String urlstr = "https://ddragon.leagueoflegends.com/realms/kr.json";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); // 여기에 문자열을 받아와라.

            List<VersionInfo> temp = null;
            VersionDto versionDto = null;
            VersionInfo versionInfo = null;

            String result = "";
            String line;

            // 받아온 문자열을 계속 한줄단위로 받고 출력
            while((line = br.readLine()) != null) {
                result = result + line;
            }

            // Gson으로 바꿀예정
//            Gson gson = new Gson();
//            versionDto = gson.fromJson(result, VersionDto.class);
//            temp = versionDto.getN();

            JsonParser jsonParser = new JsonParser();
            JsonObject k = (JsonObject) jsonParser.parse(result);
            JsonObject object = (JsonObject) k.get("n");
            itemVersion = object.get("item").getAsString();
            summonerVersion = object.get("summoner").getAsString();
            championVersion = object.get("champion").getAsString();
            profileiconVersion = object.get("profileicon").getAsString();
            mapVersion = object.get("map").getAsString();
            languageVersion = object.get("language").getAsString();
            stickerVersion = object.get("sticker").getAsString();

            System.out.println(summonerVersion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
