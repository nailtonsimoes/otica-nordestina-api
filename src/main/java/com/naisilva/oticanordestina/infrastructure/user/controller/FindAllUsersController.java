package com.naisilva.oticanordestina.infrastructure.user.controller;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.usecase.user.ListAllUsersUsecase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Listar Usuarios")
public class FindAllUsersController {
    private final ListAllUsersUsecase listAllUsersUsecase;

    public FindAllUsersController(ListAllUsersUsecase listAllUsersUsecase) {
        this.listAllUsersUsecase = listAllUsersUsecase;
    }

    @GetMapping("/v1/users/all")
    @Operation(summary = "List All Users", description = "Retorna uma lista com Todos Usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Response> listAllUsers() {
        var outPut = listAllUsersUsecase.execute();

        return outPut.stream().map(
              output -> new Response(
                      output.id(),
                      output.name(),
                      output.email()
              )
        ).toList();
    }

    public record Response(Long id, String name, String email) { }
}
