package pl.java.scalatech.predicate;

import java.util.Arrays;

public enum ItemType {

	KNIFE("knife"),
	SPOON("spoon"),
	FORK("fork"),
	PLATE("plate");
	

	private final String id;

	private ItemType(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static ItemType fromID(String id) {
		return Arrays.stream( values() ).filter( e -> e.id.equals( id ) ).findFirst().orElseThrow( () -> new IllegalArgumentException("Unknown item type ID '"+id+"'" ) );
	}
}