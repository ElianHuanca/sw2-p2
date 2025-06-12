/* package com.example.proyectosw2.Resolver;
import org.springframework.stereotype.Component;
import com.example.proyectosw2.Entity.UsuarioEntity;
import com.example.proyectosw2.Repository.UsuarioRepository;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class UsuarioResolver implements GraphQLResolver<UsuarioEntity> {

    private UsuarioRepository usuarioRepository;
    
    public UsuarioEntity __resolveReference(UsuarioEntity reference) {
        // Aquí haces lookup por ID o lo que necesites
        return usuarioRepository.findById(reference.getId()).orElse(null);
    }
}
 */