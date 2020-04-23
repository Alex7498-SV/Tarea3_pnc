package com.ncapas.tarea3.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	 @RequestMapping("/ingresar")
	 public String index() {
		 return "commons/index";
	 }
	
	@RequestMapping("/resultado")
	public ModelAndView resultado(@RequestParam String name, @RequestParam String lastname, 
			@RequestParam Date borndate, @RequestParam String address, @RequestParam String institute,
			@RequestParam String phone, @RequestParam String mobile) 
	{
		
		@SuppressWarnings("deprecation")
		Date minDate = new Date(2003, 01, 01);
		int flag = 0;
	
		List<String> errores = new ArrayList<String>();
		
		if(name.length()<= 1 || name.length()>=25) {
			errores.add("El nombre debe contener como minimo 1 caracter y como maximo 25 caracteres.");
			flag = 1;
		}
		if(lastname.length()<= 1 || lastname.length()>=25) {
			errores.add("El apellido debe contener como minimo 1 caracter y como maximo 25 caracteres.");
			flag = 1;
		}
		if(borndate.after(minDate)){
			errores.add("La fecha no puede ser menor del 1 de enero de 2003.");
			flag = 1;
		}
		if(address.length()<= 1 || address.length()>=25) {
			errores.add("La direccion debe contener como minimo 1 caracter y como maximo 25 caracteres.");
			flag = 1;
		}
		if(institute.length()<= 1 || institute.length()>=25) {
			errores.add("El nombre de la institucion debe contener como minimo 1 caracter y como maximo 100 caracteres.");
			flag = 1;
		}
		if(phone.length() != 8 ){
			errores.add("El numero de telefono fijo debe contener 8 digitos");
			flag = 1;
		}
		if(mobile.length() != 8 ){
			errores.add("El numero de telefono fijo debe contener 8 digitos");
			flag = 1;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("flag", flag);
		mav.addObject("errs", errores);
		mav.setViewName("commons/response");
		return mav;
	}
	
}
