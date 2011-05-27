package org.salgar.m2t.xml;

public class OptionsEntry {

	public OptionsEntry() {
		super();
	}

	public String key;
	public Object value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setVal(Object value) {
		this.value = value;
	}

	public OptionsEntry(String key, Object value) {
		this.key = key;
		this.value = value;
	}

}
