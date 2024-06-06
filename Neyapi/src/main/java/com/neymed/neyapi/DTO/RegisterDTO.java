package com.neymed.neyapi.DTO;

import com.neymed.neyapi.enums.Perfil;

public record RegisterDTO(String login, String password, Perfil perfil) {
}
