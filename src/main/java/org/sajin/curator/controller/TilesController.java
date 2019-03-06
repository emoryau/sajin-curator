package org.sajin.curator.controller;

import org.sajin.curator.service.TileService;
import org.sajin.data.Tile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author emory.au
 */
@RestController
public class TilesController {

	private TileService tileService;

	public TilesController(TileService tileService) {
		assert tileService != null;

		this.tileService = tileService;
	}

	@RequestMapping("/tiles")
	public Collection<Tile> tiles() {
		return tileService.getTilesForPath("");
	}
}
