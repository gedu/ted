package com.example.eduardograciano.modulation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.detailmarvelcharacter.DetailCharacterActivity;
import com.example.eduardograciano.modulation.util.JsonUtil;
import com.example.marvelpojo.MarvelCharacter;


/**
 * Created by eduardo.graciano on 11/17/17.
 */

public class MainMarvelsActivity extends AppCompatActivity {

  private MarvelCharacterAdapter adapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_marvels);

    this.adapter = new MarvelCharacterAdapter(
        JsonUtil.convertCharacters(getClass().getClassLoader()), clickListener);
    RecyclerView recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
  }

  private final MarvelCharacterAdapter.MarvelClickListener clickListener =
      new MarvelCharacterAdapter.MarvelClickListener() {
    @Override
    public void onClick(MarvelCharacter marvelCharacter) {
      Intent intent = DetailCharacterActivity.newInstance(MainMarvelsActivity.this,
          marvelCharacter);
      startActivity(intent);
    }
  };
}
