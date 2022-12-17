package com.example.ohimix_up;

public class SlideItem {
    private String word1;
    private String content1;
    private String word2;
    private String content2;

    public SlideItem(String word1, String content1, String word2, String content2) {
        this.word1 = word1;
        this.content1 = content1;
        this.word2 = word2;
        this.content2 = content2;
    }

    public String getWord1() {
        return word1;
    }

    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getWord2() {
        return word2;
    }

    public void setWord2(String word2) {
        this.word2 = word2;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }
}
