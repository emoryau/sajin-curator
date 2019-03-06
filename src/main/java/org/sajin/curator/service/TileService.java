package org.sajin.curator.service;

import org.sajin.data.Tile;

import java.util.Collection;

/**
 * @author emory.au
 */
public interface TileService {
	public Collection<Tile> getTilesForPath(String path);
}
