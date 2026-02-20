package com.uisrael.clienteconsumo.config;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // Él permite rutas públicas para que el login, assets y logout funcionen sin sesión
        if (path.startsWith("/assets/")
                || path.equals("/login")
                || path.equals("/doLogin")
                || path.equals("/logout")
                || path.equals("/403")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        boolean logged = (session != null) && Boolean.TRUE.equals(session.getAttribute("LOGGED"));
        if (!logged) {
            res.sendRedirect("/login");
            return;
        }

        String rol = (String) session.getAttribute("ROL");
        if (rol == null || rol.isBlank()) {
            res.sendRedirect("/login");
            return;
        }

        // Ajusta aquí si tus controladores usan otros paths
        boolean esDashboard   = path.equals("/") || path.startsWith("/dashboard");

        boolean esOrdenes     = path.startsWith("/ordenes");         // lista orden, nueva orden, etc
        boolean esDiagnostico = path.startsWith("/diagnostico");     // nuevodiagnostico, listardiagnostico
        boolean esReparacion  = path.startsWith("/reparaciones");    // nuevareparacion, listarreparacion

        boolean esClientes    = path.startsWith("/clientes");
        boolean esEquipos     = path.startsWith("/equipos");
        boolean esProveedores = path.startsWith("/proveedores");
        boolean esUsuarios    = path.startsWith("/usuarios");
        boolean esMaterial    = path.startsWith("/materiales") || path.startsWith("/inventario/material") || path.startsWith("/inventario");

        boolean esPagos       = path.startsWith("/pagos");
        boolean esEntregas    = path.startsWith("/entregas");

        // TECNICO, solo dashboard, ordenes lista, diagnostico, reparacion
        if ("TECNICO".equalsIgnoreCase(rol)) {

            // Él bloquea todo lo administrativo para que el técnico no gestione usuarios, clientes, inventario, ni proveedores
            if (esDashboard || esOrdenes || esDiagnostico || esReparacion|| esPagos) {
                chain.doFilter(request, response);
                return;
            }

            res.sendRedirect("/403");
            return;
        }

        // ADMIN, todo menos diagnostico y reparacion
        if ("ADMIN".equalsIgnoreCase(rol)) {

            if (esDiagnostico || esReparacion) {
                res.sendRedirect("/403");
                return;
            }

            chain.doFilter(request, response);
            return;
        }

        res.sendRedirect("/403");
    }
}
