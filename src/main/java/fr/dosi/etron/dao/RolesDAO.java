package fr.dosi.etron.dao;

import fr.dosi.etron.jpa.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path = "Role",collectionResourceRel = "Role")
public interface RolesDAO extends JpaRepository<Role,Long> {
}
