package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorRepository {
    private final List<Professor> storage = new ArrayList<>();
    public void save(Professor p) { storage.add(p); }
    public Optional<Professor> findByRegistro(String r) { return storage.stream().filter(x -> x.getRegistro().equals(r)).findFirst(); }
    public List<Professor> findAll() { return new ArrayList<>(storage); }
}
