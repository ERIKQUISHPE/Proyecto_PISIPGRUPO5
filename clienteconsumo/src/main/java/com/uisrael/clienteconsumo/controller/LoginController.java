package com.uisrael.clienteconsumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.service.IAuthServicio;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

  private final IAuthServicio authServicio;

  public LoginController(IAuthServicio authServicio) {
    this.authServicio = authServicio;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/doLogin")
  public String doLogin(@RequestParam String usuario,
                        @RequestParam String password,
                        HttpSession session) {

    var res = authServicio.login(usuario, password);

    if (res != null && res.isOk()) {
      session.setAttribute("LOGGED", true);
      session.setAttribute("ID_USUARIO", res.getIdUsuario());
      session.setAttribute("USUARIO", res.getUsuario());
      session.setAttribute("ROL", res.getRol());
      return "redirect:/dashboard";
    }

    return "redirect:/login?error=true";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/login?logout=true";
  }
  
  
  @GetMapping("/403")
  public String accesoDenegado() {
    return "403";
  }
}
