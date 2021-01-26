package com.foodtruckme.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodtruckme.dao.UsuarioDAO;
import com.foodtruckme.modelo.Usuario;
import com.foodtruckme.servicios.TokenService;

@RestController
@CrossOrigin
@RequestMapping("/autenticacion")
public class LoginControlador {
	
	private String email;
	private String password;
	private final int EXPIRATION_IN_SEC = 1800; //sesion de 30 minutos
	
	@Autowired
	UsuarioDAO uDAO;
	@Autowired
	TokenService tokenService;
	
	/*public ResponseEntity autenticar(@RequestParam("email") String email, @RequestParam("pass") String pass) {
		if (uDAO.autenticar(email, pass)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.FORBIDDEN);
	}*/
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody LoginControlador login) {
		Usuario u = uDAO.autenticar(login.getEmail(), login.getPassword());
		if (u != null) {
			String token = tokenService.generateToken(u.getEmail(), EXPIRATION_IN_SEC, u.getClass().getCanonicalName());
			return ResponseEntity.ok(token);
			//hacer un new(Credenciales(token, EXPIRATION_IN_SEC, u.getEmail(), u.getClass().getCanonicalName());
			//return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		}
		//return new ResponseEntity<Usuario>(u, HttpStatus.FORBIDDEN);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
