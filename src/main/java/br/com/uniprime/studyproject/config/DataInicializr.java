package br.com.uniprime.studyproject.config;

import br.com.uniprime.studyproject.entity.Usuario;
import br.com.uniprime.studyproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInicializr implements ApplicationListener<ContextRefreshedEvent> {

    UsuarioRepository repository;

    public DataInicializr(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Usuario> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            criarUsuario("Pedro Casagrande", "pedro@uniprime.com.br");
            criarUsuario("Fernando Franzini", "fernando@uniprime.com.br");
            criarUsuario("Andre Massucato", "andre@uniprime.com.br");
        }

        Usuario usuario = repository.findByNome("Pedro Casagrande");
//        usuario.setNome("Pedro H Casagrande");
//        repository.save(usuario);
        System.out.println(usuario.getNome());

    }

    public void criarUsuario(String nome, String email){

        Usuario usuario = new Usuario(nome, email);

        repository.save(usuario);
    }
}
