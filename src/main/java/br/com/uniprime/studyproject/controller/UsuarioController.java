package br.com.uniprime.studyproject.controller;

import br.com.uniprime.studyproject.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/usuario")
    public String getUsuarios(Model model) {
        model.addAttribute("listaUsuario", repository.findAll());

        return "usuario";
    }
}
