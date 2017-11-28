package com.example.marvelmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by eduardo.graciano on 11/17/17.
 */

public class MarvelCharacter implements Serializable {

  @SerializedName("id")
  private final int id;
  @SerializedName("name")
  private final String name;
  @SerializedName("description")
  private final String description;
  @SerializedName("thumbnail")
  private final MarvelImage image;

  public MarvelCharacter(int id, String name, String description, MarvelImage image) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.image = image;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public MarvelImage getImage() {
    return image;
  }
}
