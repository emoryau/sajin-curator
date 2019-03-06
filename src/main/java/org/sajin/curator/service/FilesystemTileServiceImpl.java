package org.sajin.curator.service;

import org.sajin.data.Tile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author emory.au
 */
@Service
public class FilesystemTileServiceImpl implements TileService {
	@Override
	public Collection<Tile> getTilesForPath(String path) {
		Tile tile1 = new Tile("x", "y", "z", LocalDate.now());
		Collection<Tile> tiles = new ArrayList<>();

		tiles.add(tile1);

		return tiles;
	}
}
