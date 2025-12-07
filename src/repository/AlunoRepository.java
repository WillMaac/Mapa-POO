package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoRepository {
    private final List<Aluno> storage = new ArrayList<>();
    public void save(Aluno a) { storage.add(a); }
    public Optional<Aluno> findByMatricula(String m) { return storage.stream().filter(x -> x.getMatricula().equals(m)).findFirst(); }
    public List<Aluno> findAll() { return new ArrayList<>(storage); }
}
