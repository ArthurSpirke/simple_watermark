package com.arthurspirke.simplecode;


public class TestWatermark {
    public static void main(String[] args) {
	String startDir = "images/origin";
	String finalDir = "images/new/";
	
	AddWatermark add = new AddWatermark(startDir, finalDir);
	
	add.addWatermark();

    }

}