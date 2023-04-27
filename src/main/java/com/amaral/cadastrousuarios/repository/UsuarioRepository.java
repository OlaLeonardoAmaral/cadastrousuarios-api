package com.amaral.cadastrousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaral.cadastrousuarios.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
    
}
