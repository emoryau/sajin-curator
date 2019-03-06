package org.sajin.curator.controller;

import org.sajin.data.Tile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author emory.au
 */
@RestController
public class TilesController {

	@RequestMapping("/tiles")
	public Collection<Tile> tiles() {
		Tile tile1 = new Tile("x", "y", "z");
		Collection<Tile> tiles = new ArrayList<>();

		tiles.add(tile1);

		return tiles;
	}
}
