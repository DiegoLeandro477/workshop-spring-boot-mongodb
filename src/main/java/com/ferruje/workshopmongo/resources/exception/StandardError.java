package com.ferruje.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long tiemstamp;
	private Integer status;
	private String error, message, path;

	public StandardError() {
		
	}

	public StandardError(Long tiemstamp, Integer status, String error, String message, String path) {
		super();
		this.tiemstamp = tiemstamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTiemstamp() {
		return tiemstamp;
	}

	public void setTiemstamp(Long tiemstamp) {
		this.tiemstamp = tiemstamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
