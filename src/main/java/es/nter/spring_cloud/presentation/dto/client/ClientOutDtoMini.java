package es.nter.spring_cloud.presentation.dto.client;


public record ClientOutDtoMini(
        long id,
        String email,
        String phone
) {
}
