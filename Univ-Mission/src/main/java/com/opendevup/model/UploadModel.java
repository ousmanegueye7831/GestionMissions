package com.opendevup.model;
import org.springframework.boot.context.properties.ConfigurationProperties;


public class UploadModel {
	

	@ConfigurationProperties(prefix = "file")
	public class FileStorageProperties {
	    private String uploadDir;

	    public String getUploadDir() {
	        return uploadDir;
	    }

	    public void setUploadDir(String uploadDir) {
	        this.uploadDir = uploadDir;
	    }
	}
	    
}
