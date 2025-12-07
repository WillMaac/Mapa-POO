package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;
import java.util.Optional;

public class AlunoService {
    private final AlunoRepository repo;
    public AlunoService(AlunoRepository repo) { this.repo = repo; }

    public void cadastrarAluno(Aluno a) {
        if (a == null) throw new IllegalArgumentException("Aluno nulo");
        Optional<Aluno> ex = repo.findByMatricula(a.getMatricula());
        if (ex.isPresent()) throw new IllegalStateException("Matrícula já existe");
        repo.save(a);
    }

    public Optional<Aluno> buscarPorMatricula(String m) { return repo.findByMatricula(m); }
    public List<Aluno> listarTodos() { return repo.findAll(); }
}
