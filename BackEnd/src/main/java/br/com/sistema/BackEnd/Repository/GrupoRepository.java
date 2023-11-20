package br.com.sistema.BackEnd.Repository;

import br.com.sistema.BackEnd.Entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Integer> {
    // Hql
    boolean existsByNome(String nome);

}
