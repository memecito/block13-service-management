package es.nter.spring_cloud.presentation.dto.client;


public record ClientOutDto(
         long id,
         String name,
         String surname,
         int age,
         String email,
         String phone
) {
}
