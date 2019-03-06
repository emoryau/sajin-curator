package org.sajin.curator.controller;

import org.sajin.curator.service.TileService;
import org.sajin.data.Tile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author emory.au
 */
@RestController
@RequestMapping("/tiles")
public class TilesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TilesController.class);

	private TileService tileService;

	public TilesController(TileService tileService) {
		assert tileService != null;

		this.tileService = tileService;
	}

	@RequestMapping("/**")
	public Collection<Tile> tiles(HttpServletRequest request) {
		String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		return tileService.getTilesForPath(requestPath.substring(6));
	}
}
