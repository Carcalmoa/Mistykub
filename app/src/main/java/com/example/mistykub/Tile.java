package com.example.mistykub;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Objects;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

public class Tile extends AppCompatTextView implements  View.OnClickListener {

    int value;
    String color;
    String black = "\u001B[30m";
    String red = "\u001B[31m";
    String green = "\u001B[33m";
    String blue = "\u001B[34m";
    private GridLayout targetCombinationGrid;
    private boolean isSelected = false;
    private float originalX, originalY;
    private float dX, dY;
    String reset = "\u001B[0m";

    public Tile(Context context, int value, String color) {
        super(context);
        this.value = value;
        this.color = color;

        // Set background color, size, and padding
        updateBackground();
        setLayoutParams(new RelativeLayout.LayoutParams(70, 70));

        if ( String.valueOf(value).length() >1) {
            setPadding(11, 15, 11, 15);
        }
        else {
            setPadding(21, 15, 21, 15);
        }

        setText(String.valueOf(value));
        setGravity(Gravity.CENTER);
        setTextColor(getColorFromString(color));
        setTypeface(Typeface.DEFAULT_BOLD);

        // Enable dragging and clicking
        setOnClickListener(this);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void toggleSelection() {
        isSelected = !isSelected;
        updateBackground();
        if (isSelected) {
            // Save the original position when selected
            originalX = getX();
            originalY = getY();
        } else {
            // Deselect the tile, reset target grid
            targetCombinationGrid = null;
        }
    }

    // Update background based on the selection state
    private void updateBackground() {
        if (isSelected) {
            setBackgroundColor(Color.LTGRAY); // Change to the desired highlight color
        } else {
            setBackgroundColor(Color.WHITE); // Change to the default background color
        }
    }

    @Override
    public void onClick(View v) {
        // Handle tile click
        toggleSelection();
    }
    public int getValue(){
        return value;
    }

    public String getColor(){
        return color;
    }

    private int getColorFromString(String color) {
        switch (color) {
            case "black":
                return Color.BLACK;
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            default:
                return Color.BLACK;
        }
    }
    @Override
    public String toString() {
        switch (this.color) {
            case "black":
                return "["+black+value+reset+"]";
            case "red":
                return "["+red+value+reset+"]";
            case "blue":
                return "["+blue+value+reset+"]";
            case "green":
                return "["+green+value+reset+"]";
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return value == tile.value && color.equals(tile.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }

}