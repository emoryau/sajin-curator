package org.sajin.data;

/**
 * @author emory.au
 */
public class Tile {
	private String name;
	private String imgSrcSmall;
	private String resource;

	public Tile(String name, String imgSrcSmall, String resource) {
		this.name = name;
		this.imgSrcSmall = imgSrcSmall;
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public String getImgSrcSmall() {
		return imgSrcSmall;
	}

	public String getResource() {
		return resource;
	}
}
