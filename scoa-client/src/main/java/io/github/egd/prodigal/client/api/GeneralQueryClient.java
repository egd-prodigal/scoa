package io.github.egd.prodigal.client.api;

import io.github.egd.prodigal.client.dto.GeneralInfoDTO;

public interface GeneralQueryClient {

    GeneralInfoDTO queryGeneral(String firstName, String lastName, String styleName);

}
