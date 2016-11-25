package com.ichunming.mg.common.constant;

public enum BucketType {
	PIC(1, "PICTURE"),
	AUDIO(2, "AUDIO"),
	VIDEO(3, "VIDEO");
	
	private int code;
	private String key;
	
	private BucketType(int code, String key) {
		this.code = code;
		this.key = key;
	}

	public int getCode() {
		return code;
	}
	
	public String getKey() {
		return key;
	}
}
