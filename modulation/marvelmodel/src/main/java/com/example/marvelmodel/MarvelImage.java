package com.example.marvelmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by eduardo.graciano on 11/17/17.
 *
 * Just to make the things faster made it Serializable,
 * but you should use {@link android.os.Parcelable}
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
