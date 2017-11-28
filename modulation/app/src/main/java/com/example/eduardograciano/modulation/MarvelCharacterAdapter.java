package com.example.eduardograciano.modulation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelpojo.MarvelCharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by eduardo.graciano on 11/17/17.
 */

public class MarvelCharacterAdapter extends RecyclerView.Adapter<MarvelCharacterAdapter.CharacterViewHolder> {

  interface MarvelClickListener {
    void onClick(MarvelCharacter marvelCharacter);
  }

  private List<MarvelCharacter> marvelCharacters;

  MarvelClickListener listener;

  public MarvelCharacterAdapter(List<MarvelCharacter> marvelCharacters, MarvelClickListener listener) {
    this.marvelCharacters = marvelCharacters;
    this.listener = listener;
  }

  @Override
  public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View rootView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.marver_character_item_list, parent, false);
    return new CharacterViewHolder(rootView);
  }

  @Override
  public void onBindViewHolder(CharacterViewHolder holder, int position) {

    MarvelCharacter character = marvelCharacters.get(position);

    holder.characterTitle.setText(character.getName());
    holder.characterDescription.setText(character.getDescription());

    Picasso.with(holder.characterImage.getContext())
        .load(character.getImage().getFullUrl())
        .placeholder(android.R.color.darker_gray)
        .into(holder.characterImage);
  }

  @Override
  public int getItemCount() {
    return marvelCharacters.size();
  }

  public class CharacterViewHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener {

    ImageView characterImage;
    TextView characterTitle, characterDescription;

    public CharacterViewHolder(View itemView) {
      super(itemView);
      itemView.setOnClickListener(this);
      characterImage = itemView.findViewById(R.id.character_image);
      characterTitle = itemView.findViewById(R.id.character_title);
      characterDescription = itemView.findViewById(R.id.character_description);
    }

    @Override
    public void onClick(View v) {
      listener.onClick(marvelCharacters.get(getAdapterPosition()));
    }
  }
}
