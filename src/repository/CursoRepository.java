package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoRepository {
    private final List<Curso> storage = new ArrayList<>();
    public void save(Curso c) { storage.add(c); }
    public Optional<Curso> findByCodigo(String codigo) {
        return storage.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
    }
    public List<Curso> findAll() { return new ArrayList<>(storage); }
}
