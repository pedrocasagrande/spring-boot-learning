package br.com.uniprime.studyproject.repository;

import br.com.uniprime.studyproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNome(String nome);

    Usuario findByEmail(String email);

    @Query("select u from Usuario u where u.nome like %?1% and u.email like %?1%")
    Usuario findByNomeEmail(String nome, String email);

}
