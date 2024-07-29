
package com.mtrm.BitacoraSena.repositories;

import com.mtrm.BitacoraSena.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long>{
    
}
