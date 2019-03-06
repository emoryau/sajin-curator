package org.sajin.data;

import java.time.LocalDate;

/**
 * @author emory.au
 */
public class Tile {
	private String name;
	private String imgSrcSmall;
	private String resource;
	private LocalDate date;

	public Tile(String name, String imgSrcSmall, String resource, LocalDate date) {
		this.name = name;
		this.imgSrcSmall = imgSrcSmall;
		this.resource = resource;
		this.date = date;
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

	public LocalDate getDate() {
		return date;
	}
}
