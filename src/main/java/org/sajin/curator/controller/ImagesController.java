package org.sajin.curator.controller;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author emory.au
 */
@RestController()
@RequestMapping("/image")
public class ImagesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImagesController.class);

	@Value("${sajin.curator.basepath}")
	private String basePath;

	private Tika tika = new Tika();

	@RequestMapping("/**")
	public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestImageName = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		requestImageName = basePath + "/" + requestImageName.substring(7);

		File requestImageFile = new File(requestImageName);
		String contentType = tika.detect(requestImageFile);

		response.setContentType(contentType);

		FileInputStream fileInputStream = new FileInputStream(requestImageFile);
		StreamUtils.copy(fileInputStream, response.getOutputStream());
		fileInputStream.close();
	}
}
