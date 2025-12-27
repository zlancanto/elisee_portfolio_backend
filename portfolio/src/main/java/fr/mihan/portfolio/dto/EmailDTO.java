package fr.mihan.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Objet minimal représentant un Email
 */
@Getter
@AllArgsConstructor
public abstract class EmailDTO {
    @NotBlank
    @NotNull
    @Email
    protected final String email;

    @NotBlank
    @NotNull
    @Size(min = 3)
    protected final String subject;

    @NotBlank
    @NotNull
    @Size(min = 10)
    protected final String message;
}
