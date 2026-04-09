package br.projetospessoais.ondemand.service;

import br.projetospessoais.ondemand.dto.DemandasDto;
import br.projetospessoais.ondemand.model.Demandas;
import br.projetospessoais.ondemand.model.Local;
import br.projetospessoais.ondemand.model.TipoDemandas;
import br.projetospessoais.ondemand.model.Usuario;
import br.projetospessoais.ondemand.repository.DemandasRepository;
import br.projetospessoais.ondemand.repository.LocalRepository;
import br.projetospessoais.ondemand.repository.TiposDemandasRepository;
import br.projetospessoais.ondemand.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DemandasService {

    private final DemandasRepository demandasRepository;
    private final TiposDemandasRepository tipoRepository;
    private final LocalRepository localRepository;
    private final UsuarioRepository usuarioRepository;

    public DemandasService(
            DemandasRepository demandasRepository,
            TiposDemandasRepository tipoRepository,
            LocalRepository localRepository,
            UsuarioRepository usuarioRepository) {

        this.demandasRepository = demandasRepository;
        this.tipoRepository = tipoRepository;
        this.localRepository = localRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // 🔹 Criar demanda
    public Demandas criarDemanda(DemandasDto dto, Long usuarioId) {

        TipoDemandas tipo = buscarTipo(dto.getTipoDemandaId());
        Local local = buscarLocal(dto.getLocalId());
        Usuario solicitante = buscarUsuario(usuarioId);

        Demandas demanda = new Demandas();
        demanda.setTipo(tipo);
        demanda.setDescricao(dto.getDescricao());
        demanda.setLocal(local);
        demanda.setSolicitante(solicitante);

        // ⚙️ automáticos
        demanda.setDataHoraCriacao(LocalDateTime.now());
        demanda.setStatus(Demandas.StatusDemanda.PENDENTE);

        return demandasRepository.save(demanda);
    }

    // 🔹 Listar todas
    public List<Demandas> listar() {
        return demandasRepository.findAll();
    }

    // 🔹 Buscar por ID
    public Demandas buscarPorId(Long id) {
        return demandasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demanda não encontrada"));
    }

    // ==============================
    // 🔒 Métodos privados (reuso)
    // ==============================

    private TipoDemandas buscarTipo(Long id) {
        return tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de demanda não encontrado"));
    }

    private Local buscarLocal(Long id) {
        return localRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));
    }

    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
