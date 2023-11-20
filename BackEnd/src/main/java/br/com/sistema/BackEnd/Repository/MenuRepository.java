package br.com.sistema.BackEnd.Repository;

import br.com.sistema.BackEnd.Entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> , JpaSpecificationExecutor {
    // Hql com Specification
    boolean existsByNome(String nome);
}