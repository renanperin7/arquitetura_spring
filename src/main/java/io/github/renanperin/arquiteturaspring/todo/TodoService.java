package io.github.renanperin.arquiteturaspring.todo;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public TodoRepository repository;
    public TodoValidator validator;
    public EmailSender emailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, EmailSender emailSender) {
        this.emailSender = emailSender;
        this.validator = todoValidator;
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "concluído" : "não concluído";
        emailSender.enviar("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
