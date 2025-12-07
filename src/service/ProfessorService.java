package service;

import model.Professor;
import repository.ProfessorRepository;
import java.util.List;
import java.util.Optional;

public class ProfessorService {
    private final ProfessorRepository repo;
    public ProfessorService(ProfessorRepository repo) { this.repo = repo; }

    public void cadastrarProfessor(Professor p) {
        if (p == null) throw new IllegalArgumentException("Professor nulo");
        Optional<Professor> ex = repo.findByRegistro(p.getRegistro());
        if (ex.isPresent()) throw new IllegalStateException("Registro já existe");
        repo.save(p);
    }

    public Optional<Professor> buscarPorRegistro(String r) { return repo.findByRegistro(r); }
    public List<Professor> listarTodos() { return repo.findAll(); }
}
