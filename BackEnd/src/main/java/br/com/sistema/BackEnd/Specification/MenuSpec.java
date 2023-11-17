package br.com.sistema.BackEnd.Specification;

import br.com.sistema.BackEnd.Entity.MenuEntity;
import br.com.sistema.BackEnd.ModelDTO.MenuDTO;
import br.com.sistema.BackEnd.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


public abstract class MenuSpec {

    public static Specification<MenuEntity> nomeLike(String nome){
        return  (root, query, criteriaBuilder) -> criteriaBuilder.like (criteriaBuilder.upper(root.get("nome")),"%"+nome+"%".toUpperCase());
    }
    public static Specification<MenuEntity> descricaoLike(String descricao){
        return  (root, query, criteriaBuilder) -> criteriaBuilder.like (criteriaBuilder.upper(root.get("descricao")),"%"+descricao+"%".toUpperCase());
    }
    public static Specification<MenuEntity> codigoEqual(Integer codigo){
        return  (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("codigo"),codigo);
    }
    public static Specification<MenuEntity> ordemEqual(Integer ordem){
        return  (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("ordem"),ordem);
    }
    public static Specification<MenuEntity> ordemMaiorQ(Integer ordem){
        return  (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("ordem"),ordem);
    }
}
