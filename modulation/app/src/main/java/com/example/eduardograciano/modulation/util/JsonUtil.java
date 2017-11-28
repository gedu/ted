package com.example.eduardograciano.modulation.util;


import com.example.marvelpojo.MarvelCharacter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by eduardo.graciano on 11/17/17.
 */

public class JsonUtil {

  public static List<MarvelCharacter> convertCharacters(ClassLoader loader) {
    String json = loadJsonFromResources(loader, "characters.json");
    Gson gson = new Gson();
    Type marvelList = new TypeToken<List<MarvelCharacter>>(){}.getType();
    return gson.fromJson(json, marvelList);
  }

  public static String loadJsonFromResources(ClassLoader loader, String jsonName ){
    InputStream inputStream = loader.getResourceAsStream(jsonName);
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    return readFrom(reader);
  }

  public static String readFrom(BufferedReader reader) {
    String json;
    StringBuilder builder = new StringBuilder();
    try {
      while ((json = reader.readLine()) != null) builder.append(json);
      return builder.toString();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }
}
