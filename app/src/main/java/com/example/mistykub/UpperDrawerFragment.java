package com.example.mistykub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class UpperDrawerFragment extends BottomSheetDialogFragment {
    private GridLayout combinationGrid;
    private Player player;

    public UpperDrawerFragment(Player player) {
        this.player = player;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upper_drawer, container, false);

        combinationGrid = view.findViewById(R.id.combinationGrid);
        ArrayList<Tile> hand = player.handTiles;

        for (int i = 0; i < hand.size(); i++) {
            Tile originalTile = hand.get(i);
            Tile tile = new Tile(requireContext(), originalTile.value, originalTile.color);

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            int margin = 10;
            layoutParams.setMargins(margin, margin, margin, margin);
            int row = 0;
            int col = i;

            layoutParams.rowSpec = GridLayout.spec(row);
            layoutParams.columnSpec = GridLayout.spec(col);
            tile.setLayoutParams(layoutParams);
            combinationGrid.addView(tile);
        }
        return view;
    }


}
