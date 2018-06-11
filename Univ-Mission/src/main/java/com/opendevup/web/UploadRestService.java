package com.opendevup.web;



import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;





import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin( "*" )
public class UploadRestService {
	private static String UPLOAD_DIR = "uploads";
	 private static String UPLOADED_FOLDER = "D//";
	@RequestMapping(value="/Remboursement/upload", method=RequestMethod.POST, consumes=MimeTypeUtils.MULTIPART_FORM_DATA_VALUE)
	public String upload(@RequestParam(value="file") MultipartFile file, HttpServletRequest request) {
		try {
			String fileName = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("") + UPLOAD_DIR +  File.separator + fileName;
			System.out.println(path);
			saveFile(file.getInputStream(), path);
			return "Successelly upload :" + fileName;
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
	private void saveFile(InputStream inputStream, String path) {
		try {
			OutputStream outputStream = new FileOutputStream(new File(path));
			int read = 0;
			byte []bytes = new byte[1024];
			while((read = inputStream.read()) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@PostMapping("/api/upload")
    public ResponseEntity<?> uploadFileMulti(
            @RequestParam("extraField") String extraField,
            @RequestParam("files") MultipartFile[] uploadfiles) {

        //Logger.debug("Multiple file upload!");

        // Get file name
        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity<>("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFiles(Arrays.asList(uploadfiles));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - "
                + uploadedFileName, HttpStatus.OK);

    }
	   private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

	        for (MultipartFile file : files) {

	            if (file.isEmpty()) {
	                continue; //next pls
	            }

	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);

	        }

	    }
}
