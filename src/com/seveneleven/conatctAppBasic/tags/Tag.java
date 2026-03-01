/*
 * @author Developer
 * @version 11
 */

package com.seveneleven.conatctAppBasic.tags;

import java.util.Objects;

public class Tag {
	private String name;
	public Tag(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(!(o instanceof Tag)) return false;
		Tag tag=(Tag) o;
		return name.equalsIgnoreCase(tag.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
