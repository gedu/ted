package com.example.marvelpojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by eduardo.graciano on 11/17/17.
 */

public class MarvelImage implements Serializable {

  @SerializedName("path")
  private final String url;
  @SerializedName("extension")
  private final String extension;

  public MarvelImage(String url, String extension) {
    this.url = url;
    this.extension = extension;
  }

  public String getFullUrl() {
    return url + "." + extension;
  }
}
