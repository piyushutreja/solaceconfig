package com.sapient.controller;

import java.util.List;

import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.sapient.jms.CometSolaceProperties;

@RestController
public class AppController<T> {
	
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CometSolaceProperties prop;

	

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll() throws Exception {		


/*		InitialContext cxt = new InitialContext();

		if (cxt == null) {
			throw new Exception("Issue in JNDI ocntext");
		}

		Object obj =  cxt.lookup("JNDI/CF/spring");
		if(obj==null)
		{
			System.out.println("jNDI NOT FOUND");
		}
		*/
		System.out.println(env.getProperty("comet.solace.jms.session-comet-size")+"SessionSize"+prop.getSessionSize());
		return "Hi2";

	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<T>> getbyID(@PathVariable("id") long id) {
		return null;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody T t, UriComponentsBuilder ucBuilder) {
		return null;

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<T> update(@PathVariable("id") long id, @RequestBody T t) {
		return null;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<T> delete(@PathVariable long id) {
		return null;
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<T> deleteAll() {
		return null;
	}

}
