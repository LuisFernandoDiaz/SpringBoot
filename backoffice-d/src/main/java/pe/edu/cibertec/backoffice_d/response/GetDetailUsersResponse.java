package pe.edu.cibertec.backoffice_d.response;

import pe.edu.cibertec.backoffice_d.dto.UserDetailDto;

public record GetDetailUsersResponse(String doe,
                                     String error,
                                     UserDetailDto userDetailDto) {
}
