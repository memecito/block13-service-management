package es.nter.spring_cloud.presentation.dto.client;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ClientInDto {

    @NotBlank(message = "name required")
    private String name;
    private String surname;
    private int age;
    @NotBlank(message = "email required")
    @Email(message = "email format not valid")
    private String email;
    @Size(min = 9, max = 9, message = "size invalid")
    private String phone;
}
