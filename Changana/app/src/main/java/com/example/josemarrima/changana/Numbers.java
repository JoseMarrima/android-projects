package com.example.josemarrima.changana;

/**
 * Created by Jose Marrima on 16/5/2017.
 */

public class Numbers {
    // my default language words(m stands for private members)
    private String mDefaultLanguage;

    //my Changana language words
    private String mChanganaLanguage;

    //image resource for the category with images
    private int imageReseourceId;

    //audio resource for play short audio on all the categories
    private int mAudioResourceId;

    public Numbers(String mDefaultLanguage, String mChanganaLanguage){
        this.mDefaultLanguage = mDefaultLanguage;
        this.mChanganaLanguage = mChanganaLanguage;
    }

    public Numbers(String mDefaultLanguage, String mChanganaLanguage, int imageReseourceId, int mAudioResourceId) {
        this.mDefaultLanguage = mDefaultLanguage;
        this.mChanganaLanguage = mChanganaLanguage;
        this.imageReseourceId = imageReseourceId;
        this.mAudioResourceId = mAudioResourceId;
    }


    //getters
    public String getmChanganaLanguage() {
        return mChanganaLanguage;
    }

    public String getmDefaultLanguage() {
        return mDefaultLanguage;
    }

    public int getImageReseourceId() {
        return imageReseourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
