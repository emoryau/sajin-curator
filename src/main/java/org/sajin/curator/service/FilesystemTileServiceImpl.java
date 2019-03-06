package org.sajin.curator.service;

import org.apache.tika.Tika;
import org.sajin.data.Tile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author emory.au
 */
@Service
public class FilesystemTileServiceImpl implements TileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilesystemTileServiceImpl.class);

	private Tika tika = new Tika();

	@Value("${sajin.curator.basepath}")
	private String basePath;

	public Collection<Tile> getTilesForPath(String path) {
		Collection<Tile> tiles = new ArrayList<>();

		String sanitizedPath = basePath + sanitize(path);
		LOGGER.info("PATH: {}", sanitizedPath);

		File currentDirectory = new File(sanitizedPath);

		File[] fileList = currentDirectory.listFiles();

		if (fileList == null) {
			LOGGER.warn("Inaccessible path {}, returning empty tiles array", sanitizedPath);
			return tiles;
		}

		for (File f : fileList) {
			String name = f.getName();
			LocalDateTime date = LocalDateTime.ofEpochSecond(f.lastModified(), 0, ZoneOffset.UTC);
			String imgSrc;
			String resource;

			if (f.isDirectory()) {
				imgSrc = "http://www.clipartpanda.com/clipart_images/clip-art-categories-61813609";
				resource = "/tiles" + path + f.getName();
			} else {
				try {
					if (!isPicture(f)) {
						// Do not add tiles for non-picture file types
						continue;
					}
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
				imgSrc = "/image" + path + "/" + f.getName();
				resource = imgSrc;
			}

			Tile tile = new Tile(name, imgSrc, resource, date.toLocalDate());
			tiles.add(tile);
		}

		return tiles;
	}

	private boolean isPicture(File f) throws IOException {

		String mimeType = tika.detect(f);
		return mimeType.startsWith("image/");
	}

	private String sanitize(String substring) {
		String sanitizedString = substring.replaceAll("\\.\\.|:", "");

		return sanitizedString;
	}
}
