package service;

import model.Curso;
import repository.CursoRepository;
import java.util.List;
import java.util.Optional;

public class CursoService {
    private final CursoRepository repo;
    public CursoService(CursoRepository repo) { this.repo = repo; }

    public void cadastrarCurso(Curso c) {
        if (c == null) throw new IllegalArgumentException("Curso nulo");
        Optional<Curso> ex = repo.findByCodigo(c.getCodigo());
        if (ex.isPresent()) throw new IllegalStateException("Código já cadastrado");
        repo.save(c);
    }

    public Optional<Curso> buscarPorCodigo(String codigo) { return repo.findByCodigo(codigo); }
    public List<Curso> listarTodos() { return repo.findAll(); }
}
